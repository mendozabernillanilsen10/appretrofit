package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import com.example.library.formato_t1.data_format_1;
import com.example.library.formato_t2.data_format_2;
import com.example.library.formato_t3.data_format_3;
import com.example.library.formato_t4.data_format_4;
import com.example.myapplication.Cliente.Url;
import com.example.myapplication.Service.Service;
import com.example.myapplication.adapter.TrabajadorAdapter;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity4 extends AppCompatActivity {

    TextView    textView;
    Button button;

    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            proceso_04();
        });


    }

    private void proceso1()  {

        Service ser = Url.Mediador();
        Call<Map<String, Object>> call = ser.optner_lista_one();

        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    data_format_1 obj = new data_format_1();
                    obj.setResponse(response.body());
                    textView.setText( obj.getBody().toString());
                } else {
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {

            }
        });


    }





    private void proceso2() {

        Service ser = Url.Mediador2();
        Call<Map<String, Object>> call = ser.optner_lista_two();

        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    data_format_2 obj = new data_format_2();
                    obj.setResponse(response.body());
                    //listar el contenido de la lista
                    List<Map<String, Object>> listss = obj.listbody();
                    // Acceder a los datos según sea necesario
                    Map<String, Object> content = obj.body("unidadavance");
                    // HEADER
                    List<Map<String, Object>> header = obj.headerlist("formatocosecha");
                    //DATA
                    List<Map<String, Object>> data = obj.contentlist("formatocosecha");
                    textView.setText(data.toString());
                } else {

                }
            }
            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {

            }
        });
    }


    private void proceso3() {

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Service ser = Url.Mediador3();
        Call<Map<String, Object>> call = ser.optner_lista_three();

        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    data_format_3 obj = new data_format_3();
                    obj.setBody(response.body());
                    textView.setText(obj.getContent().toString());
                } else {
                    // Manejar error
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {

            }
        });
    }

    private void proceso_04() {

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
                    // Manejar error
                }
            }
            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {

            }
        });

    }

}