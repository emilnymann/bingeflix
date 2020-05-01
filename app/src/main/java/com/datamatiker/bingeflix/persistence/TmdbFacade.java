package com.datamatiker.bingeflix.persistence;

import android.content.Context;
import android.util.Log;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class TmdbFacade {

    private static final String APIKEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNjBiZGU0MjUzODk4MGExNGRhNDhjNGRmNmM2MDlmZiIsInN1YiI6IjVlMGZjZmYxNjYzYjg3MDAxNzgwNDRmYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QrT1L9EJFzkmNpaA5cE8Jzzh4RdJe8CV05NSi-Zh1y4";

    public void cacheShowById(int id, Context context) {

        AndroidNetworking.get("https://api.themoviedb.org/3/tv/{seriesId}")
                .addPathParameter("seriesId", String.valueOf(id))
                .addHeaders("Content-Type", "application/json;charset=utf-8")
                .addHeaders("Authorization", "Bearer " + APIKEY)
                .addHeaders("Accept", "application/json")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        TvShowRepository tvShowRepository = new TvShowRepository(context);
                        Log.d(TAG, "onResponse: " + response.toString());
                        tvShowRepository.addNewTvShow(response);

                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("FAILLLLLLLLL");
                    }
                });

    }

    public void cacheApiConfig(Context context) {

        AndroidNetworking.get("https://api.themoviedb.org/3/configuration")
                .addHeaders("Content-Type", "application/json;charset=utf-8")
                .addHeaders("Authorization", "Bearer " + APIKEY)
                .addHeaders("Accept", "application/json")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        ApiConfigRepository apiConfigRepository = new ApiConfigRepository(context);
                        Log.d(TAG, "onResponse: " + response.toString());
                        apiConfigRepository.addApiConfig(response);

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

}
