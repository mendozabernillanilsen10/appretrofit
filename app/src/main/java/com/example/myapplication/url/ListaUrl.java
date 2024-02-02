package com.example.myapplication.url;


import com.example.library.format.model.URL;

import java.util.ArrayList;
import java.util.List;

public class ListaUrl  {
    private List<URL> listaUrl;
    public ListaUrl() {
        this.listaUrl = new ArrayList<>();
        listaUrl.add(new URL("http://34.194.71.145/dashboardQA/agv/gmotareo/get/agv2023/GetHarvestGroup.php?iddatabase=AGVTEAM_TEST&iddatabase2=AGROVISIONCORP", 1));
        listaUrl.add(new URL("http://gmoplus-backend-qas.agvperu.com/gmoplus_back/api/v1/gmoprod/materia-prima/list/?idDatabase=AGROVISIONCORP&idEmpresa=001&server=QAS", 2));

    }
    public List<URL> getListaUrl() {
        return listaUrl;
    }
    public void setListaUrl(List<URL> listaUrl) {
        this.listaUrl = listaUrl;
    }
}