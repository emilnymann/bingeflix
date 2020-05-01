package com.datamatiker.bingeflix.persistence;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.lifecycle.LiveData;
import com.datamatiker.bingeflix.event.GetTvShowEvent;
import com.datamatiker.bingeflix.model.GenreConverter;
import com.datamatiker.bingeflix.model.Genres;
import com.datamatiker.bingeflix.model.Networks;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class TvShowRepository {

    private Context context;
    private static final long cacheTime = 24l;

    public TvShowRepository(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addNewTvShow(final JSONObject jsonObject) {
        AsyncTask.execute(() -> {

            try {

                DbTvShow tvShow = new DbTvShow(
                        jsonObject.getInt("id"),
                        jsonObject.getString("name"),
                        jsonObject.getString("overview"),
                        jsonObject.getInt("number_of_seasons"),
                        jsonObject.getInt("number_of_episodes"),
                        jsonObject.getJSONArray("episode_run_time").getInt(0),
                        jsonObject.getString("status"),
                        jsonObject.getString("original_language"),
                        jsonObject.getString("poster_path"),
                        jsonObject.getDouble("vote_average")
                );

                if (!jsonObject.isNull("first_air_date")) {
                    tvShow.firstAirDate = jsonObject.getString("first_air_date");
                }

                if (!jsonObject.isNull("last_air_date")) {
                    tvShow.lastAirDate = jsonObject.getString("last_air_date");
                }

                if (!jsonObject.isNull("homepage")) {
                    tvShow.homepage = jsonObject.getString("homepage");
                }

                if (!jsonObject.isNull("genres")) {
                    JSONArray genres = jsonObject.getJSONArray("genres");
                    ArrayList<String> genreList = new ArrayList<>();

                    for (int i = 0; i < genres.length(); i++) {
                        JSONObject genre = genres.getJSONObject(i);
                        genreList.add(genre.getString("name"));
                    }

                    tvShow.genres = new Genres(genreList);
                    
                }

                if (!jsonObject.isNull("networks")) {
                    JSONArray networks = jsonObject.getJSONArray("networks");
                    ArrayList<String> networkList = new ArrayList<>();

                    for (int i = 0; i < networks.length(); i++) {
                        JSONObject genre = networks.getJSONObject(i);
                        networkList.add(genre.getString("name"));
                    }

                    tvShow.networks = new Networks(networkList);

                }

                DbDatabase.getInstance(context).dbTvShowDAO().insertTvShow(tvShow);
                EventBus.getDefault().post(new GetTvShowEvent(tvShow));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        });
    }

    public void getTvShowById(int id) {
        AsyncTask.execute(() -> {
            TmdbFacade tmdbFacade = new TmdbFacade();
            DbTvShow dbTvShow = DbDatabase.getInstance(context).dbTvShowDAO().getTvShowById(id);

            if (dbTvShow == null) {
                tmdbFacade.cacheShowById(id, context);
            } else if (dbTvShow.cacheDate.isBefore(LocalDateTime.now().minusHours(cacheTime))) {
                Log.d(TAG, "getTvShowById: Cache has expired"); // TODO: implement database update when cache is expired
            } else {
                EventBus.getDefault().post(new GetTvShowEvent(dbTvShow));
            }
        });
    }

    public List<DbTvShow> getAllTvShows() {
        return DbDatabase.getInstance(context).dbTvShowDAO().getAllTvShows();
    }

    public LiveData<Integer> getTvShowCount() {
        return DbDatabase.getInstance(context).dbTvShowDAO().countTvShows();
    }

    public void deleteTvShow(DbTvShow dbTvShow) {
        AsyncTask.execute(() -> DbDatabase.getInstance(context).dbTvShowDAO().deleteTvShow(dbTvShow));
    }

}
