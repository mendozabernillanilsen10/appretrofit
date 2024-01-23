package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.adpater.TrabajadorAdapter;
import com.example.myapplication.config.conn;
import com.example.myapplication.modelo.Trabajador;
import com.example.myapplication.service.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerViewPopular = findViewById(R.id.listaReserva);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


            Service ser;
            ser = conn.Mediador();
        long startTime = System.currentTimeMillis();

        Call<List<Trabajador>> call =   ser.obtenerTrabajadores();
        call.enqueue(new Callback<List<Trabajador>>() {
            @Override
            public void onResponse(Call<List<Trabajador>> call, Response<List<Trabajador>> response) {
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;

                if(response.isSuccessful()) {
                    List<Trabajador> T = response.body();
                        adapterPopular = new TrabajadorAdapter((ArrayList<Trabajador>) T);
                        recyclerViewPopular.setAdapter(adapterPopular);
                    }else{

                }
                Toast.makeText(MainActivity.this, "elapsedTime : " +elapsedTime  + "ms", Toast.LENGTH_SHORT).show();

                Log.d("Tiempo de respuesta", "Tiempo total: " + elapsedTime + "ms");

            }
            @Override
            public void onFailure(Call<List<Trabajador>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        }

}