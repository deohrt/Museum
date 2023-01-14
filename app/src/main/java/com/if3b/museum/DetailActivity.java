package com.if3b.museum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    Button btnLokasi;
    TextView tvNamaMuseum, tvTentang;
    ImageView ivFoto;
    String yNama, yTentang, yFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnLokasi = findViewById(R.id.btn_lokasi);
        tvNamaMuseum = findViewById(R.id.tv_nama_Museum);
        tvTentang = findViewById(R.id.tv_tentang_museum);
        ivFoto = findViewById(R.id.iva_foto);

        Intent ambil = getIntent();
        yNama = ambil.getStringExtra("xNama");
        yTentang = ambil.getStringExtra("xTentang");
        yFoto = ambil.getStringExtra("xFoto");

        tvNamaMuseum.setText(yNama);
        tvTentang.setText(yTentang);

        Glide
                .with(DetailActivity.this)
                .load(yFoto)
                .into(ivFoto);

        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=" + yNama);
                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW, location);
                startActivity(bukaLokasi);
            }
        });
    }
}