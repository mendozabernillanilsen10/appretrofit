package com.example.library.format.body;


import android.util.Log;

import com.example.library.database.JSQLite;
import com.example.library.format.formato_t1.data_format_1;
import com.example.library.format.formato_t4.data_format_4;
import com.example.library.format.model.URL;
import com.example.library.format.retrofit.Service;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormatMain {
    private List<URL> listaUrl;

    JSQLite jSQLite;

    public FormatMain(List<URL> listaUrl, JSQLite jSQLite) {
        this.listaUrl = listaUrl;
        this.jSQLite = jSQLite;
    }

    public List<URL> getListaUrl() {
        return listaUrl;
    }


    public String proceso() {
        StringBuilder responseBuilder = new StringBuilder();
        List<URL> listaUrl = this.listaUrl;
        for (URL url : listaUrl) {
            String baseUrl = obtenerBaseUrl(url.getUrl());
            String endpoint = obtenerEndpoint(url.getUrl());
            Retrofit retrofit = construirRetrofit(baseUrl);

            if (url.getTipoPetiocion() == 1) {
                Log.d("---------------", url.getUrl());
                Service interfaceApi = retrofit.create(Service.class);
                Call<Map<String, Object>> call = interfaceApi.optner_lista_uno(endpoint);
                llamadoApiFormato_uno(call);
            }else if(url.getTipoPetiocion() == 1){

            }

        }
        return responseBuilder.toString();
    }

    private String  llamadoApiFormato_uno(Call<Map<String, Object>> call) {
        call.enqueue(new retrofit2.Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, retrofit2.Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Map<String, Object> map = response.body();
                    data_format_1 dataFormat1 = new data_format_1();
                    Log.d("---------------", "data -...........................: " + map.toString());
                    dataFormat1.setResponse(map , jSQLite);

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


    public void setListaUrl(List<URL> listaUrl  , JSQLite jSQLite) {
        this.listaUrl = listaUrl;
        this.jSQLite = jSQLite;
    }

    public FormatMain() {
        // Default constructor
    }




    public String proceso4() {
        StringBuilder responseBuilder = new StringBuilder();
        List<URL> listaUrl = this.listaUrl;

        for (URL url : listaUrl) {
            String baseUrl = obtenerBaseUrl(url.getUrl());
            String endpoint = obtenerEndpoint(url.getUrl());
            Retrofit retrofit = construirRetrofit(baseUrl);

            if (url.getTipoPetiocion() == 4) {
                Log.d("---------------", url.getUrl());
                Service interfaceApi = retrofit.create(Service.class);
                Call<List<Map<String, Object>>> call = interfaceApi.optner_lista_cuatro(endpoint);
                String tabla = url.getTabla();
                llamadoApiFormato_cuatro(call, tabla);
            } else {
                if (url.getTipoPetiocion() == 1) {
                    Log.d("---------------", url.getUrl());
                    Service interfaceApi = retrofit.create(Service.class);
                    Call<Map<String, Object>> call = interfaceApi.optner_lista_uno(endpoint);
                    llamadoApiFormato_uno(call);
                }
            }
        }

        return responseBuilder.toString();
    }






    private void llamadoApiFormato_cuatro(Call<List<Map<String, Object>>> call, String TABLE) {
        data_format_4 dataFormat4 = new data_format_4();
        call.enqueue(new retrofit2.Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, retrofit2.Response<List<Map<String, Object>>> response) {
                if (response.isSuccessful()) {
                    List<Map<String, Object>> dataList = response.body();

                    Log.d("---------------", "data -...........................: " + dataList.toString() + "tabla -...........................: " + TABLE);
                    dataFormat4.setResponse(dataList, jSQLite,TABLE);
                } else {
                }
            }
            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }










    /*private String llamadoApiFormato_4(Call<Map<String, Object>> call, String tableName) {
        call.enqueue(new retrofit2.Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, retrofit2.Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Map<String, Object> map = response.body();
                    data_format_4 dataFormat4 = new data_format_4();
                    Log.d("---------------", "data -...........................: " + map.toString());
                    dataFormat4.setResponse(map, jSQLite, tableName);
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
        return "";
    }



    /*public String proceso3() {
        StringBuilder responseBuilder = new StringBuilder();
        List<URL> listaUrl = this.listaUrl;
        for (URL url : listaUrl) {
            String baseUrl = obtenerBaseUrl(url.getUrl());
            String endpoint = obtenerEndpoint(url.getUrl());
            Retrofit retrofit = construirRetrofit(baseUrl);

            if (url.getTipoPetiocion() == 1) {
                Log.d("---------------", url.getUrl());
                Service interfaceApi = retrofit.create(Service.class);
                Call<Map<String, Object>> call = interfaceApi.optner_lista_uno(endpoint);
                llamadoApiFormato_uno(call);
            } else if (url.getTipoPetiocion() == 3) {
                Log.d("---------------", url.getUrl());
                Service interfaceApi = retrofit.create(Service.class);
                Call<Map<String, Object>> call = interfaceApi.optner_lista_tres(endpoint);
                llamadoApiFormato_tres(call, "parammateriaprima");
            }
        }
        return responseBuilder.toString();
    }


    private String llamadoApiFormato_tres(Call<Map<String, Object>> call, String tableName) {
        call.enqueue(new retrofit2.Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, retrofit2.Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Map<String, Object> map = response.body();
                    data_format_3 dataFormat3 = new data_format_3();
                    Log.d("---------------", "data -...........................: " + map.toString());
                    dataFormat3.setContent((List<Map<String, Object>>) map.get("content"), jSQLite, tableName);
                } else {
                    // Manejar respuesta no exitosa si es necesario
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
        return "";
    }*/













    // Additional constructor to handle List<ULR>

}
