package com.example.trendingten.service;

import android.util.Log;

import com.example.trendingten.apis.Api;
import com.example.trendingten.apis.Retro;
import com.example.trendingten.models.Thumbnail;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ApiCalls {

    private static final String TAG = "APi";

//    public ApiCalls(ApiService complete) {
//        this.complete = complete;
//    }

    private Api getApi() {
        Retrofit retrofit = Retro.getRetrofit();
        return retrofit.create(Api.class);
    }


    public void getContent() {
        Api api = getApi();
        Call<List<Thumbnail>> call = api.getContent();

        call.enqueue(new Callback<List<Thumbnail>>() {
            @Override
            public void onResponse(Call<List<Thumbnail>> call, Response<List<Thumbnail>> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Thumbnail>> call, Throwable t) {
                Log.d(TAG, "onFailure: exception hai bhai");
            }
        });

    }


}
