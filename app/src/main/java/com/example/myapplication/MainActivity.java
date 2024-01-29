package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Cliente.conn;
import com.example.myapplication.Service.Service;
import com.example.myapplication.db.DatabaseHelper;
import com.example.myapplication.model.Trabajador;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button filledTonalButton;
    private TextView textView10;
    private Button  segundaPantalla;
    private RecyclerView recyclerViewPopular;
    private SweetAlertDialog loadingDialog;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView10 = findViewById(R.id.textView10);
        filledTonalButton = findViewById(R.id.filledTonalButton);
        segundaPantalla = findViewById(R.id.segundaPantalla);

        segundaPantalla.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity4.class);
            startActivity(intent);
        });
/*
        filledTonalButton.setOnClickListener(v -> {
            new DownloadAndSaveTask().execute();
        });



*/
    }
/*
    private class DownloadAndSaveTask extends AsyncTask<Void, Void, List<Trabajador>> {
        private long startTime;
        private long downloadTime;
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
        protected List<Trabajador> doInBackground(Void... voids) {
            Service ser = conn.Mediador();
            Call<optner_lista_one> call = ser.optner_lista_one();
            try {
                Response<List<Trabajador>> response = call.execute();
                if (response.isSuccessful()) {
                    return response.body();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(List<Trabajador> trabajadores) {
            super.onPostExecute(trabajadores);

            loadingDialog.cancel();
            if (trabajadores != null) {
                saveTrabajadores(trabajadores);
            } else {
                // Manejo de errores en la respuesta no exitosa
                Toast.makeText(MainActivity.this, "Error en la descarga", Toast.LENGTH_SHORT).show();
            }
        }
        private void saveTrabajadores(List<Trabajador> trabajadores) {
            DatabaseHelper dataSource = new DatabaseHelper(MainActivity.this, "db_taaSSS", null, 1);
            SQLiteDatabase database = dataSource.getWritableDatabase();
            database.beginTransaction();
            try {
                for (Trabajador trabajador : trabajadores) {
                    database.insert("usuarios", null, trabajador.toValues());
                }
                database.setTransactionSuccessful();
                long insertEndTime = System.currentTimeMillis();
                long insertTime = insertEndTime - startTime;

                long insertTimeInSeconds = insertTime / 1000;
                long totalTimeInSeconds = (downloadTime + insertTime) / 1000;
                // Convertir tiempos a minutos
                long insertTimeInMinutes = insertTimeInSeconds / 60;
                long totalTimeInMinutes = totalTimeInSeconds / 60;

                textView10.setText("Descarga: " + downloadTime + "ms, " +
                        "Inserción: " + insertTimeInSeconds + "s (" + insertTimeInMinutes + "min), " +
                        "Total: " + totalTimeInSeconds + "s (" + totalTimeInMinutes + "min), " +
                        "Se guardaron " + trabajadores.size() + " trabajadores");
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Error al guardar: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            } finally {
                database.endTransaction();
            }
        }
    }*/
}
