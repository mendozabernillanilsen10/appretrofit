package com.example.myapplication.Service;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("GetHarvestGroup.php?iddatabase=AGVTEAM_TEST&iddatabase2=AGROVISIONCORP")
    Call<Map<String, Object>> optner_lista_one();

    @GET("GetQuery.php?iddatabase=AGROVISIONTEAM&query=exec GetListTrabTotal_mobile 'AGROVISIONCORP';")
    Call<List<Map<String, Object>>> optner_lista_two();

    @GET("GetQuerygg.php?iddatabase=AGVTEAM_TEST&query=exec MobileGetListParamMateriaPrima 'AGROVISIONCORP', '001',1;")
    Call<Map<String, Object>> optner_lista_three();

}
