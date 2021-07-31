package com.example.trendingten.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {

    public static volatile Retrofit retrofit;
//    private static final String URL = "http://192.168.43.64:8080/";
    private static final String URL = "http://10.0.2.2:8080/";


    private Retro() {
        throw new RuntimeException();
    }


    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            synchronized (Retro.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }

        return retrofit;
    }
}
