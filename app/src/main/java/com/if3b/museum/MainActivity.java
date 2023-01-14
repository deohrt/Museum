package com.if3b.museum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMuseum;
    ArrayList<ModelMuseum> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMuseum = findViewById(R.id.rv_Museum);
        rvMuseum.setHasFixedSize(true);

        data.addAll(DataMuseum.ambilDataMuseum());
        tampilDataCard();
    }

    private void tampilDataCard(){
        rvMuseum.setLayoutManager(new LinearLayoutManager(this));
        CardItem adapterCard = new CardItem(data, MainActivity.this);
        rvMuseum.setAdapter(adapterCard);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_right, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            Intent pindah = new Intent(MainActivity.this, About.class);
            startActivity(pindah);
        }
        return super.onOptionsItemSelected(item);
    }
}