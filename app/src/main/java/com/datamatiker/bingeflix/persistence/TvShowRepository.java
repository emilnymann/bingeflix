package com.datamatiker.bingeflix.persistence;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TvShowRepository {

    private Context context;

    public TvShowRepository(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addNewTvShow(final JSONObject jsonObject) {
        AsyncTask.execute(() -> {

            try {

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
                    tvShow.firstAirDate = dateFormat.parse(jsonObject.getString("first_air_date"));
                }

                if (!jsonObject.isNull("last_air_date")) {
                    tvShow.lastAirDate = dateFormat.parse(jsonObject.getString("last_air_date"));
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

                    tvShow.genres = genreList;
                    
                }

                if (!jsonObject.isNull("networks")) {
                    JSONArray networks = jsonObject.getJSONArray("networks");
                    ArrayList<String> networkList = new ArrayList<>();

                    for (int i = 0; i < networks.length(); i++) {
                        JSONObject genre = networks.getJSONObject(i);
                        networkList.add(genre.getString("name"));
                    }

                    tvShow.networks = networkList;

                }

                DbDatabase.getInstance(context).dbTvShowDAO().insertTvShow(tvShow);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });
    }

    public LiveData<DbTvShow> getTvShowById(int id) {
        return DbDatabase.getInstance(context).dbTvShowDAO().getTvShowById(id);
    }

    public LiveData<List<DbTvShow>> getAllTvShows() {
        return DbDatabase.getInstance(context).dbTvShowDAO().getAllTvShows();
    }

    public LiveData<Integer> getTvShowCount() {
        return DbDatabase.getInstance(context).dbTvShowDAO().countTvShows();
    }

    public void deleteTvShow(DbTvShow dbTvShow) {
        AsyncTask.execute(() -> DbDatabase.getInstance(context).dbTvShowDAO().deleteTvShow(dbTvShow));
    }

}
