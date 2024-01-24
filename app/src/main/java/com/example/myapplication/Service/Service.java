package com.example.myapplication.Service;

import com.example.myapplication.model.Trabajador;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("GetQuery.php?iddatabase=AGROVISIONTEAM&query=exec GetListTrabTotal_mobile 'AGROVISIONCORP'")
    Call<List<Trabajador>> obtenerTrabajadores();

}
