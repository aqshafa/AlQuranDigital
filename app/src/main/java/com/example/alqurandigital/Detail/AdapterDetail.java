package com.example.alqurandigital.Detail;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alqurandigital.Model.ResponseDetail;
import com.example.alqurandigital.R;

import java.util.List;

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.DetailHolder> {

    private List<ResponseDetail> list;

    public AdapterDetail(List<ResponseDetail> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ayat, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {
        holder.bindView(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DetailHolder extends RecyclerView.ViewHolder {
        TextView tvNomor, tvArab, tvArti, tvLatin;

        public DetailHolder(@NonNull View itemView) {
            super(itemView);

            tvNomor = itemView.findViewById(R.id.noayat);
            tvArab = itemView.findViewById(R.id.Arab);
            tvArti = itemView.findViewById(R.id.Arti);
            tvLatin = itemView.findViewById(R.id.Latin);

        }

        private void bindView(ResponseDetail data){
            String latin = Html.fromHtml(String.valueOf(data.getTr())).toString();

            tvNomor.setText(data.getNomor());
            tvArab.setText(data.getAr());
            tvArti.setText(data.getId());
            tvLatin.setText(latin);
        }
    }
}
