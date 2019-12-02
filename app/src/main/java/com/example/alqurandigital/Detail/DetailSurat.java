package com.example.alqurandigital.Detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.alqurandigital.Model.ResponseDetail;
import com.example.alqurandigital.R;
import com.example.alqurandigital.Service.APIClient;
import com.example.alqurandigital.Service.BaseAPIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSurat extends AppCompatActivity {

    RecyclerView rvDetail;
    BaseAPIService apiService;
    List<ResponseDetail> data;
    AdapterDetail adapterDetail;
    String nomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surat);

        rvDetail = findViewById(R.id.rvDetail);
        apiService = APIClient.getSurah();
        data = new ArrayList<>();
        rvDetail.setLayoutManager(new LinearLayoutManager(this));
        nomor = getIntent().getStringExtra("KEY");
        getDetailSurat(nomor);
    }

    private void getDetailSurat(String no){
        final ProgressDialog loading = ProgressDialog.show(this, null, "loading...", false, false);
        Call<List<ResponseDetail>> listCall = apiService.getListDetail(no);
        listCall.enqueue(new Callback<List<ResponseDetail>>() {
            @Override
            public void onResponse(Call<List<ResponseDetail>> call, Response<List<ResponseDetail>> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    data = response.body();
                    adapterDetail = new AdapterDetail(data);
                    rvDetail.setAdapter(adapterDetail);
                }else {
                    loading.dismiss();
                    Toast.makeText(DetailSurat.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseDetail>> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(DetailSurat.this, "Tidak Ada Koneksi Internet", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
