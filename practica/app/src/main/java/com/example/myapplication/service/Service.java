package com.example.myapplication.service;

import com.example.myapplication.modelo.Trabajador;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
public interface Service {
    @GET("ListTrabajadores2021.php?iddatabase=AGROVISIONTEAM&iddatabase2=AGROVISIONCORP&idempresa=001")
    Call<List<Trabajador>> obtenerTrabajadores();
}
