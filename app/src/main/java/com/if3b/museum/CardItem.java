package com.if3b.museum;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardItem extends RecyclerView.Adapter<CardItem.ClassViewHolder> {
    private ArrayList<ModelMuseum> dataMuseum;
    private Context ctx;

    public CardItem(ArrayList<ModelMuseum> dataMuseum, Context ctx) {
        this.dataMuseum = dataMuseum;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.card_item_museum, parent, false);

        return new ClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelMuseum museum = dataMuseum.get(position);
        holder.tvNama.setText(museum.getNama());
        holder.tvTentang.setText(museum.getTentang());

        Glide
                .with(ctx)
                .load(museum.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xNama, xTentang, xFoto;

                xNama = museum.getNama();
                xTentang = museum.getTentang();
                xFoto = museum.getFoto();

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xFoto);
                ctx.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataMuseum.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama, tvTentang;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFoto = itemView.findViewById(R.id.iv_Museum);
            tvNama = itemView.findViewById(R.id.tv_nama_Museum);
            tvTentang = itemView.findViewById(R.id.tv_tentang_museum);
        }
    }
}
