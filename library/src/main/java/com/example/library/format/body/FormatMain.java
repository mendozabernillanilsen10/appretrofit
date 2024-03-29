package com.example.library.format.body;


import android.util.Log;

import com.example.library.database.JSQLite;
import com.example.library.format.formato_t1.data_format_1;
import com.example.library.format.formato_t2.data_format_2;
import com.example.library.format.formato_t3.data_format_3;
import com.example.library.format.formato_t4.data_format_4;
import com.example.library.format.model.URL;
import com.example.library.format.retrofit.Service;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
        long startTime = System.currentTimeMillis();

        try {
            for (URL url : listaUrl) {
                String baseUrl = obtenerBaseUrl(url.getUrl());
                String endpoint = obtenerEndpoint(url.getUrl());
                Retrofit retrofit = construirRetrofit(baseUrl);
                Service interfaceApi = retrofit.create(Service.class);

                switch (url.getTipoPeticion()) {
                    case 1:
                        Log.d("------formatoUno-------", "------------------------------------------------------------------");
                        Call<Map<String, Object>> call = interfaceApi.optner_lista_uno(endpoint);
                        llamadoApiFormato_uno(call);
                        break;
                    case 2:
                        Log.d("----formatodos-----", "------------------------------------------------------------------");
                        Call<Map<String, Object>> call2 = interfaceApi.optner_lista_dos(endpoint);
                        llamadoApiFormato_dos(call2);
                        break;
                    case 3:
                        Log.d("----formatotres-----", "------------------------------------------------------------------");
                        Call<Map<String, Object>> call3 = interfaceApi.optner_lista_tres(endpoint);
                        llamadoApiFormato_tres(call3 ,url.getTabla() );
                        break;
                    case 4:
                        Log.d("---------------", url.getUrl());
                        Call<List<Map<String, Object>>> call4 = interfaceApi.optner_lista_cuatro(endpoint);
                        llamadoApiFormato_cuatro(call4 ,url.getTabla() );
                        break;
                }
            }
        } catch (Exception e) {
            // Manejar errores o registrar mensajes según sea necesario
            Log.e("FormatMain", "Error durante el proceso: " + e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        responseBuilder.append("Total time: ").append(totalTime).append(" ms");
        return responseBuilder.toString();
    }
    private String  llamadoApiFormato_uno(Call<Map<String, Object>> call) {
        long startTime = System.currentTimeMillis();
        StringBuilder responseBuilder = new StringBuilder();
        call.enqueue(new retrofit2.Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, retrofit2.Response<Map<String, Object>> response) {
                long endTime = System.currentTimeMillis(); // Obtener el tiempo de finalización
                if (response.isSuccessful()) {
                    Map<String, Object> map = response.body();
                    data_format_1 dataFormat1 = new data_format_1();
                    dataFormat1.setResponse(map , jSQLite);
                    long downloadTime = endTime - startTime; // Calcular el tiempo de descarga en milisegundos
                    responseBuilder.append("Tiempo de descarga: format 02 : ").append(downloadTime).append(" ms");
                } else {

                }
            }
            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.d("TAG", "error: " + t.getMessage());
            }
        });
        return "";
    }
   private String llamadoApiFormato_dos(Call<Map<String, Object>> call){
       long startTime = System.currentTimeMillis();
        StringBuilder responseBuilder = new StringBuilder();
       call.enqueue(new Callback<Map<String, Object>>() {
           @Override
           public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
               long endTime = System.currentTimeMillis(); // Obtener el tiempo de finalización
               if (response.isSuccessful()) {
                     Map<String, Object> map = response.body();
                     data_format_2 dataFormat = new data_format_2();
                     dataFormat.setResponse(map , jSQLite);
                    long downloadTime = endTime - startTime; // Calcular el tiempo de descarga en milisegundos
                    responseBuilder.append("Tiempo de descarga: format 02 : ").append(downloadTime).append(" ms");
                } else {

                }
           }
           @Override
           public void onFailure(Call<Map<String, Object>> call, Throwable t) {

           }
       });
        return responseBuilder.toString();
   }
   private String llamadoApiFormato_tres(Call<Map<String, Object>> call , String Table) {
       long startTime = System.currentTimeMillis();
       StringBuilder responseBuilder = new StringBuilder();
       call.enqueue(new Callback<Map<String, Object>>() {
           @Override
           public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
               long endTime = System.currentTimeMillis(); // Obtener el tiempo de finalización

               if (response.isSuccessful()) {
                   Map<String, Object> map = response.body();
                   data_format_3 dataFormat = new data_format_3();
                   dataFormat.setBody(map, jSQLite,Table);
                   long downloadTime = endTime - startTime;
                   responseBuilder.append("Tiempo de descarga: format 03 : ").append(downloadTime).append(" ms");

               } else {

               }
           }
           @Override
           public void onFailure(Call<Map<String, Object>> call, Throwable t) {

           }
       });
       return responseBuilder.toString();

   }
    private void llamadoApiFormato_cuatro(Call<List<Map<String, Object>>> call, String TABLE) {
        long startTime = System.currentTimeMillis();
        StringBuilder responseBuilder = new StringBuilder();
        call.enqueue(new retrofit2.Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, retrofit2.Response<List<Map<String, Object>>> response) {
                long endTime = System.currentTimeMillis(); // Obtener el tiempo de finalización

                if (response.isSuccessful()) {
                    data_format_4 dataFormat4 = new data_format_4();
                    List<Map<String, Object>> dataList = response.body();
                    dataFormat4.setResponse(dataList, jSQLite,TABLE);
                    long downloadTime = endTime - startTime;
                    responseBuilder.append("Tiempo de descarga: format 04 :").append(downloadTime).append(" ms");

                } else {

                }
            }
            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
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

    // Additional constructor to handle List<ULR>

}
