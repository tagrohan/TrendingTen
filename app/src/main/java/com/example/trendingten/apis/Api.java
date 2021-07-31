package com.example.trendingten.apis;

import com.example.trendingten.models.Thumbnail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    //read all
    @GET("/get_content")
    Call<List<Thumbnail>> getContent();
}
