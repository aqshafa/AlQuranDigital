package com.example.alqurandigital.Service;

import com.example.alqurandigital.Model.ResponseDetail;
import com.example.alqurandigital.Model.ResponseList;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BaseAPIService {

    @GET("data.json?print=pretty")
    Call<List<ResponseList>> getListSurah();

    @GET("surat/{nomor}.json?print=pretty")
    Call<List<ResponseDetail>> getListDetail(@Path("nomor") String nomor);

}
