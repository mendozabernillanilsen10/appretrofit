package com.example.library.format.retrofit;

import java.security.Key;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface Service {
    @GET
    Call<Map<String, Object>> optner_lista_uno(@Url String fullUrl  );
    @GET
    Call<Map<String, Object>> optner_lista_dos(@Url String fullUrl );
    @GET
    Call<Map<String, Object>> optner_lista_tres(@Url String fullUrl);
    @GET
    Call<List<Map<String, Object>>>optner_lista_cuatro(@Url String fullUrl);
    //Call<List<Map<String, Object>>>optner_lista_cuatro(@Url String fullUrl, @Header("Authorization") String token);


}
