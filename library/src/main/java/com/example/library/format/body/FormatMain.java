package com.example.library.format.body;


import android.util.Log;

import com.example.library.format.formato_t1.data_format_1;
import com.example.library.format.model.ULR;
import com.example.library.format.retrofit.ConsumoRetrofit;
import com.example.library.format.retrofit.Service;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormatMain {
    private List<ULR> listaUrl;
    public List<ULR> getListaUrl() {
        return listaUrl;
    }

    public String proceso() {
        StringBuilder responseBuilder = new StringBuilder();

        List<ULR> listaUrl = this.listaUrl;

        for (ULR url : listaUrl) {
            if (url.getTipoPetiocion() == 1) {
                String baseUrl = obtenerBaseUrl(url.getUrl());
                String endpoint = obtenerEndpoint(url.getUrl());
                Retrofit retrofit = construirRetrofit(baseUrl);
                Service interfaceApi = retrofit.create(Service.class);
                Call<Map<String, Object>> call = interfaceApi.optner_lista_tres(endpoint);
                realizarLlamadaApi(call);

            }


        }
        return responseBuilder.toString();
    }

    private String  realizarLlamadaApi(Call<Map<String, Object>> call) {
        call.enqueue(new retrofit2.Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, retrofit2.Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Map<String, Object> map = response.body();
                    data_format_1 dataFormat1 = new data_format_1();
                    dataFormat1.setResponse(map);

                } else {

                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
        return "";
    }

    private String obtenerEndpoint(String fullUrl) {
        int lastSlashIndex = fullUrl.lastIndexOf("/");

        if (lastSlashIndex != -1 && lastSlashIndex < fullUrl.length() - 1) {
            return fullUrl.substring(lastSlashIndex + 1); // Excluyendo "/" si no es el último carácter
        } else {
            return "";
        }
    }

    private String obtenerBaseUrl(String fullUrl) {
        int lastSlashIndex = fullUrl.lastIndexOf("/");

        if (lastSlashIndex != -1) {
            return fullUrl.substring(0, lastSlashIndex + 1); // Including "/"
        } else {
            // If there's no "/", consider the entire URL as the base URL
            return fullUrl;
        }
    }


    private Retrofit construirRetrofit(String baseUrl) {

        if (baseUrl.isEmpty()) {
            return null;
        }
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    public void setListaUrl(List<ULR> listaUrl) {
        this.listaUrl = listaUrl;
    }

    public FormatMain() {
        // Default constructor
    }

    // Additional constructor to handle List<ULR>

}
