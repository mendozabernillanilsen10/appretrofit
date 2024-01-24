package com.example.myapplication.Service;

import com.example.myapplication.model.Trabajador;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("ListTrabajadores2021.php?iddatabase=AGROVISIONTEAM&iddatabase2=AGROVISIONCORP&idempresa=001")
    Call<List<Trabajador>> obtenerTrabajadores();



}
