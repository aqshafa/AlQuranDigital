package com.example.alqurandigital.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static Retrofit getClient(){
        return new Retrofit.Builder()
                .baseUrl("https://al-quran-8d642.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static BaseAPIService getSurah(){
        return getClient().create(BaseAPIService.class);
    }

}
