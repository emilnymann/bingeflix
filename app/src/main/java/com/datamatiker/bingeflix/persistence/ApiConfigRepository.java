package com.datamatiker.bingeflix.persistence;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.datamatiker.bingeflix.event.GetApiConfigEvent;
import com.datamatiker.bingeflix.event.GetTvShowEvent;
import com.datamatiker.bingeflix.model.Genres;
import com.datamatiker.bingeflix.model.PosterSizes;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ApiConfigRepository {

    private Context context;
    private static final long cacheTime = 24L;

    public ApiConfigRepository(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addApiConfig(final JSONObject jsonObject) {
        AsyncTask.execute(() -> {

            try {
                ArrayList<String> posterSizeList = new ArrayList<>();

                DbApiConfig dbApiConfig = new DbApiConfig(
                        jsonObject.getString("base_url"),
                        jsonObject.getString("secure_base_url")
                );

                if (!jsonObject.isNull("poster_sizes")) {
                    JSONArray posterSizes = jsonObject.getJSONArray("poster_sizes");

                    for (int i = 0; i < posterSizes.length(); i++) {
                        String posterSize = posterSizes.getString(i);
                        posterSizeList.add(posterSize);
                    }

                }

                dbApiConfig.posterSizes = new PosterSizes(posterSizeList);
                DbDatabase.getInstance(context).dbApiConfigDAO().insertDbApiConfig(dbApiConfig);
                getApiConfig();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        });
    }

    public void updateApiConfig(JSONObject jsonObject) {
        AsyncTask.execute(() -> {

            try {

                ArrayList<String> posterSizeList = new ArrayList<>();

                DbApiConfig dbApiConfig = DbDatabase.getInstance(context).dbApiConfigDAO().getDbApiConfig();
                dbApiConfig.baseUrl = jsonObject.getString("base_url");
                dbApiConfig.secureBaseUrl = jsonObject.getString("secure_base_url");

                if (!jsonObject.isNull("poster_sizes")) {
                    JSONArray posterSizes = jsonObject.getJSONArray("poster_sizes");

                    for (int i = 0; i < posterSizes.length(); i++) {
                        String posterSize = posterSizes.getString(i);
                        posterSizeList.add(posterSize);
                    }
                }

                dbApiConfig.posterSizes = new PosterSizes(posterSizeList);
                DbDatabase.getInstance(context).dbApiConfigDAO().updateDbAPiConfig(dbApiConfig);
                getApiConfig();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        });
    }

    public void getApiConfig() {
        AsyncTask.execute(() -> {

            TmdbFacade tmdbFacade = new TmdbFacade();
            DbApiConfig dbApiConfig = DbDatabase.getInstance(context).dbApiConfigDAO().getDbApiConfig();

            if (dbApiConfig == null) {
                tmdbFacade.cacheApiConfig(context);
            } else if (dbApiConfig.cacheDate.isBefore(LocalDateTime.now().minusHours(cacheTime))) {
                Log.d(TAG, "getApiConfig: cache has expired");
            } else {
                EventBus.getDefault().post(new GetApiConfigEvent(dbApiConfig));
            }

        });
    }

}
