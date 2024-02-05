package com.example.myapplication.url;


import com.example.library.format.model.URL;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.PUT;

public class ListaUrl  {
    private List<URL> listaUrl;
    public ListaUrl() {
        this.listaUrl = new ArrayList<>();
       /* listaUrl.add(new URL("http://34.194.71.145/dashboardQA/agv/gmotareo/get/agv2023/GetHarvestGroup.php?iddatabase=AGVTEAM_TEST&iddatabase2=AGROVISIONCORP",
                1));*/
        listaUrl.add(new URL("http://gmoplus-backend-qas.agvperu.com/gmoplus_back/api/v1/gmoprod/materia-prima/list/?idDatabase=AGROVISIONCORP&idEmpresa=001&server=QAS",
                2));
          listaUrl.add(new URL("http://34.194.71.145/dashboardQA/agv/gmotareo/get/GetQuerygg.php?iddatabase=AGVTEAM_TEST&query=exec MobileGetListParamMateriaPrima 'AGROVISIONCORP', '001',1;"
                ,3, "" , "parammateriaprima"));

     listaUrl.add(new URL("http://34.194.71.145/dashboardQA/agv/gmotareo/get/GetQuery.php?iddatabase=AGVTEAM_TEST&query=exec GetListCosechaLabor 'AGROVISIONCORP', '001';",
                4, "", "tabla_api4_01"));


        listaUrl.add(new URL("http://52.3.85.45/dashboard/agv/gmotareo/get/ListTrabajadores2021.php?iddatabase=AGROVISIONTEAM&iddatabase2=AGROVISIONCORP&idempresa=001",
                4, "", "tabla_api4_02"));
 /*
        listaUrl.add(new URL("http://52.3.85.45/dashboard/agv/gmotareo/get/GetQuery.php?iddatabase=AGROVISIONTEAM&query=exec GetListTrabTotal_mobile 'AGROVISIONCORP';",
                4, "", "trabajadores_global"));*/

    }

    public List<URL> pbjeto_04() {
        this.listaUrl = new ArrayList<>();

        listaUrl.add(new URL("http://52.3.85.45/dashboard/agv/gmotareo/get/GetQuery.php?iddatabase=AGROVISIONTEAM&query=exec GetListTrabTotal_mobile 'AGROVISIONCORP';",
                4, "", "trabajadores_global"));
        return listaUrl;
    }

    public List<URL> getListaUrl() {
        return listaUrl;
    }
    public void setListaUrl(List<URL> listaUrl) {
        this.listaUrl = listaUrl;
    }
}