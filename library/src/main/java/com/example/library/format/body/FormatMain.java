package com.example.library.format.body;


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

    public String toString() {

        String reponse = "";
        List<ULR> listaUrl = this.listaUrl;

        for( ULR url : listaUrl)
        {
            if(url.getTipoPetiocion() == 1){
                String baseUrl = obtenerBaseUrl(url.getUrl());
                String endpoint = obtenerEndpoint(url.getUrl());

                Retrofit retrofit = construirRetrofit(baseUrl);
                if (retrofit == null) {
                    return "Error en la URL";
                }
                Service interfaceApi = retrofit.create(Service.class);

                Call<Map<String, Object>> call = interfaceApi.optner_lista_tres(endpoint);
                realizarLlamadaApi(call);

            }
        }

       return "URL: " + reponse;

    }

    private void realizarLlamadaApi(Call<Map<String, Object>> call)
    {


    }

    private String obtenerEndpoint(String fullUrl) {
        int lastSlashIndex = fullUrl.lastIndexOf("/");
        if (lastSlashIndex != -1) {
            return fullUrl.substring(lastSlashIndex + 1); // Excluyendo "/"
        } else {
            return "";
        }
    }
    private String obtenerBaseUrl(String fullUrl) {

        int lastSlashIndex = fullUrl.lastIndexOf("/");
        if (lastSlashIndex != -1) {
            return fullUrl.substring(0, lastSlashIndex + 1); // Incluyendo "/"
        } else {
            return "";
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
