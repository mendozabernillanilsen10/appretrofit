package com.example.myapplication;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.library.database.JSQLite;
import com.example.library.format.formato_t4.data_format_4;

import com.example.library.jother.jdir;
import com.example.myapplication.db.SQLite;
import com.example.myapplication.db.SQLiteHelper;
import com.example.myapplication.utils.others.files;


public class MainActivity extends AppCompatActivity implements data_format_4.DataSaveCallback {
    private TextView textView;

    private Button filledTonalButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView( ) {
        textView = findViewById(R.id.textView);
        filledTonalButton = findViewById(R.id.filledTonalButton);

        SQLite sqlite = new SQLite(this);
        sqlite.abrir();

        JSQLite jSQLite = new JSQLite(this, jdir.pathPrincipal((AppCompatActivity) this) + files.DIR_DB_FINAL, 206);


        textView.setText("Número de tablas: " + jSQLite.getTableCount());
        sqlite.cerrar();

        filledTonalButton.setOnClickListener(v -> {
           // new DownloadAndSaveTask().execute();
        });
    }

    @Override
    public void onDataSaveComplete(String message) {
        textView.setText(message);
    }

    @Override
    public void onDataSaveError(Exception e) {
        Toast.makeText(MainActivity.this, "Error al guardar: " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    /*
    private class DownloadAndSaveTask extends AsyncTask<Void, Void, data_format_4> {
        private long startTime;
        private data_format_4 dataFormat4;
        private SQLiteDatabase database;
        private String tableName;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
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


    */
}


