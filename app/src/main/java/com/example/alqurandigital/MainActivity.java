package com.example.alqurandigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.alqurandigital.Model.ResponseList;
import com.example.alqurandigital.Service.APIClient;
import com.example.alqurandigital.Service.BaseAPIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    AdapterSurat adapterSurat;
    List<ResponseList> list;
    BaseAPIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rvMain);
        list = new ArrayList<>();
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        apiService = APIClient.getSurah();
        getDataList();
    }

    private void getDataList(){
        final Call<List<ResponseList>> listCall = apiService.getListSurah();
        listCall.enqueue(new Callback<List<ResponseList>>() {
            @Override
            public void onResponse(Call<List<ResponseList>> call, Response<List<ResponseList>> response) {
                if (response.isSuccessful()){
                    list = response.body();
                    adapterSurat = new AdapterSurat(list);
                    rvMain.setAdapter(adapterSurat);
                }else {
                    Toast.makeText(MainActivity.this, "Response Gagal!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseList>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "Tidak Ada Koneksi Internet", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
