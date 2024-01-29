package com.example.myapplication.Service;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("GetHarvestGroup.php?iddatabase=AGVTEAM_TEST&iddatabase2=AGROVISIONCORP")
    Call<Map<String, Object>> optner_lista_one();

}
