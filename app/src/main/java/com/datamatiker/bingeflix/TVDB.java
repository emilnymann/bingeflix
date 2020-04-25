package com.datamatiker.bingeflix;

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

import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class TVDB {

    private JSONObject singleCurrentResult;
    private JSONArray multipleCurrentResult;

    private static final String APIKEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNjBiZGU0MjUzODk4MGExNGRhNDhjNGRmNmM2MDlmZiIsInN1YiI6IjVlMGZjZmYxNjYzYjg3MDAxNzgwNDRmYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QrT1L9EJFzkmNpaA5cE8Jzzh4RdJe8CV05NSi-Zh1y4";

//    public void authorize(String key) {
//
//        AndroidNetworking.get("https://api.themoviedb.org/3/tv/1396")
//                .addHeaders("Content-Type", "application/json;charset=utf-8")
//                .addHeaders("Accept", "application/json")
//                .addHeaders("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNjBiZGU0MjUzODk4MGExNGRhNDhjNGRmNmM2MDlmZiIsInN1YiI6IjVlMGZjZmYxNjYzYjg3MDAxNzgwNDRmYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QrT1L9EJFzkmNpaA5cE8Jzzh4RdJe8CV05NSi-Zh1y4")
//                .setTag("megakomplicerettag")
//                .setPriority(Priority.MEDIUM)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, "onResponse : " + response);
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        if (anError.getErrorCode() != 0) {
//                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
//                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
//                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
//                        }
//                        else {
//                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
//                        }
//                    }
//                });
//    }

    public TVShow getShowById(int id) {

        TVShow result;

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
                        // TODO: how to extract response so we can return it to the caller?
                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("FAILLLLLLLLL");
                    }
                });

        return result;

    }

}
