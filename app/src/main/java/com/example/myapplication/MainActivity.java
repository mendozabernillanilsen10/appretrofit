package com.example.myapplication;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.formato_t4.data_format_4;
import com.example.myapplication.Cliente.Url;
import com.example.myapplication.Service.Service;
import com.example.myapplication.adapter.TrabajadorAdapter;
import com.example.myapplication.db.DatabaseHelper;

import java.util.List;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements data_format_4.DataSaveCallback {
    private TextView textView;
    private Button button;
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;
    private Button filledTonalButton;
    private SweetAlertDialog loadingDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        filledTonalButton = findViewById(R.id.filledTonalButton);
        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        button.setOnClickListener(v -> {
            lectura_Api_04();
        });

        filledTonalButton.setOnClickListener(v -> {
            new DownloadAndSaveTask().execute();
        });
    }

    @Override
    public void onDataSaveComplete(String message) {
        loadingDialog.cancel();
        textView.setText(message);
    }

    @Override
    public void onDataSaveError(Exception e) {
        loadingDialog.cancel();
        Toast.makeText(MainActivity.this, "Error al guardar: " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }


    private class DownloadAndSaveTask extends AsyncTask<Void, Void, data_format_4> {
        private long startTime;
        private data_format_4 dataFormat4;
        private SQLiteDatabase database;
        private String tableName;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loadingDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.PROGRESS_TYPE);
            loadingDialog.setCancelable(false);
            loadingDialog.setTitleText("| Descargando...");
            loadingDialog.show();
            startTime = System.currentTimeMillis();
        }

        @Override
        protected data_format_4 doInBackground(Void... voids) {
            Service ser = Url.Mediador5();

            Call<List<Map<String, Object>>> call = ser.optner_lista_cuatro();
            try {
                Response<List<Map<String, Object>>> response = call.execute();
                if (response.isSuccessful()) {
                    return new data_format_4(response.body());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(data_format_4 dataFormat4) {
            super.onPostExecute(dataFormat4);
            if (dataFormat4 != null) {
                guardarRegistros(dataFormat4);
            } else {
                Toast.makeText(MainActivity.this, "Error en la descarga", Toast.LENGTH_SHORT).show();
            }
        }

        private void guardarRegistros(data_format_4 dataFormat4) {
            DatabaseHelper dataSource = new DatabaseHelper(MainActivity.this, "bd_prueba8", null, 1);
            SQLiteDatabase database = dataSource.getWritableDatabase();
            dataFormat4.guardarRegistros(database, startTime, MainActivity.this);
        }
    }

    private void lectura_Api_04() {

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Service ser = Url.Mediador5();
        Call<List<Map<String, Object>>> call = ser.optner_lista_cuatro();
        call.enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if (response.isSuccessful()) {

                    data_format_4 obj = new data_format_4();
                    obj.setBody(response.body());
                    adapterPopular = new TrabajadorAdapter(obj.getBody());
                    recyclerViewPopular.setAdapter(adapterPopular);
                } else {
                }
            }
            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {
            }
        });

    }
}
