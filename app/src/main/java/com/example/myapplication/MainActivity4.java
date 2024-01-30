package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import com.example.library.formato_t1.data_t1;
import com.example.library.formato_t1.objet_t1;
import com.example.library.formato_t3.objet_t3;
import com.example.library.formato_t4.objet_t4;
import com.example.myapplication.Cliente.conn;
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

        Service ser = conn.Mediador();
        Call<Map<String, Object>> call = ser.optner_lista_one();

        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {


                    Map<String, Object> dataList = response.body();
                    boolean idempresa = (boolean) dataList.get("status");
                    Map<String, data_t1> data = (Map<String, data_t1>) dataList.get("data");
                    objet_t1 obj = new objet_t1();
                    obj.setStatus(idempresa);
                    obj.setData(data);

                    textView.setText(obj.isStatus() + " "  +obj.getData().toString());

                    // Acceder a los datos según sea necesario

                } else {
                    // Manejar error
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {

            }
        });


    }





    private void procesotres() {

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Service ser = conn.Mediador3();
        Call<Map<String, Object>> call = ser.optner_lista_three();

        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {

                    Map<String, Object> dataList = response.body();
                    //List<Map<String, Object>> data = (List<Map<String, Object>>) dataList.get("header");
                    objet_t3 obj = new objet_t3();
                    obj.setHeader((List<Map<String, Object>>) dataList.get("header"));
                    obj.setContent((List<Map<String, Object>>) dataList.get("content"));
                    textView.setText(obj.getContent().toString());
                    // Acceder a los datos según sea necesario

                } else {
                    // Manejar error
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {

            }
        });
    }


    // proceso para obtener datos de la api formato numero 1


    // proceso para obtener datos de la api formato numero 5

    private void proceso_04() {

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Service ser = conn.Mediador5();
        Call<List<Map<String, Object>>> call = ser.optner_lista_cuatro();
        call.enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if (response.isSuccessful()) {
                    List<Map<String, Object>> dynamicList = response.body();

                    Map<String, Object> dataList = dynamicList.get(10000);
                    textView.setText(dataList.toString());

                    objet_t4 obj = new objet_t4();
                    obj.setDynamicList(dynamicList);

                    adapterPopular = new TrabajadorAdapter(obj.getDynamicList());
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