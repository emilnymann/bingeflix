package com.datamatiker.bingeflix.persistence;

import android.content.Context;
import android.util.Log;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class TmdbFacade {

    private static final String APIKEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNjBiZGU0MjUzODk4MGExNGRhNDhjNGRmNmM2MDlmZiIsInN1YiI6IjVlMGZjZmYxNjYzYjg3MDAxNzgwNDRmYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QrT1L9EJFzkmNpaA5cE8Jzzh4RdJe8CV05NSi-Zh1y4";

    public void getShowById(int id, Context context) {

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


                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("FAILLLLLLLLL");
                    }
                });

    }

}
