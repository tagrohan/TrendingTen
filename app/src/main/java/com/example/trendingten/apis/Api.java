package com.example.trendingten.apis;

import com.example.trendingten.models.Card;
import com.example.trendingten.models.Thumbnail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    //read all
    @GET("/get_content")
    Call<List<Thumbnail>> getContent();

    @GET("/get_cards")
    Call<List<Card>> getCards();
    
    // new method to take card via id need to added
//       @GET("/get_cards")
//     Call<List<Card>> getCards();
}
