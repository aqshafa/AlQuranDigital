package com.example.alqurandigital;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alqurandigital.Detail.DetailSurat;
import com.example.alqurandigital.Model.ResponseList;

import java.util.List;

public class AdapterSurat extends RecyclerView.Adapter<AdapterSurat.SuratHolder> {

    private List<ResponseList> listSurah;

    public AdapterSurat(List<ResponseList> listSurah){
        this.listSurah = listSurah;
    }

    @NonNull
    @Override
    public SuratHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SuratHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SuratHolder holder, int position) {
        holder.bindView(listSurah.get(position));

    }

    @Override
    public int getItemCount() {
        return listSurah.size();
    }

    public class SuratHolder extends RecyclerView.ViewHolder {
        TextView tvNo, tvNama, tvJumlah;
        ImageView btnSound;

        public SuratHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNoSurah);
            tvNama = itemView.findViewById(R.id.tvNamaSurah);
            tvJumlah = itemView.findViewById(R.id.tvJumlahAyat);
            btnSound = itemView.findViewById(R.id.btnSound);
        }

        private void bindView(final ResponseList data){
            tvNo.setText(data.getNomor());
            tvNama.setText(data.getNama());
            tvJumlah.setText(String.valueOf(data.getAyat()) + " Ayat");
            final String nomor = String.valueOf(data.getNomor());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), DetailSurat.class)
                    .putExtra("KEY", nomor));
                }
            });
        }
    }
}
