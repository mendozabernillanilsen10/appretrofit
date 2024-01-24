package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Cliente.conn;
import com.example.myapplication.Service.Service;
import com.example.myapplication.adapter.TrabajadorAdapter;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.db.TrabajadorDataSource;
import com.example.myapplication.model.Trabajador;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular;
    private SweetAlertDialog loadingDialog;

    private Button filledTonalButton;
    private TextView textView10;
    private RecyclerView recyclerViewPopular;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView10 = findViewById(R.id.textView10);
        filledTonalButton = findViewById(R.id.filledTonalButton);

        filledTonalButton.setOnClickListener(v -> {
            initRecyclerView();
        });
    }

    private void initRecyclerView() {
        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        loadingDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        loadingDialog.setCancelable(false);
        loadingDialog.setTitleText("Sincronizando...");
        loadingDialog.show();
        Service ser;
        ser = conn.Mediador();
        long startTime = System.currentTimeMillis();

        Call<List<Trabajador>> call =   ser.obtenerTrabajadores();
        call.enqueue(new Callback<List<Trabajador>>() {
            @Override
            public void onResponse(Call<List<Trabajador>> call, Response<List<Trabajador>> response) {
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;

                loadingDialog.setCancelable(true);
                loadingDialog.cancel();

                if(response.isSuccessful()) {
                    List<Trabajador> trabajadores = response.body();
                    saveTrabajadores(trabajadores);
                }else{
                }

            }
            @Override
            public void onFailure(Call<List<Trabajador>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void saveTrabajadores(List<Trabajador> trabajadores) {
        DatabaseHelper dataSource = new DatabaseHelper(this, "db", null, 1);
        SQLiteDatabase database = dataSource.getWritableDatabase();
        database.beginTransaction();
        try {
            for (Trabajador trabajador : trabajadores) {
                database.insert("usuarios", null, trabajador.toValues());
            }
            database.setTransactionSuccessful();
            textView10.setText("Se guardaron " + trabajadores.size() + " trabajadores");

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            database.endTransaction();
        }

    }





}