package com.example.myapplication.url;


import com.example.library.format.model.ULR;

import java.util.ArrayList;
import java.util.List;

public class ListaUrl  {
    private List<ULR> listaUrl;
    public ListaUrl() {
        this.listaUrl = new ArrayList<>();
        listaUrl.add(new ULR("http://34.194.71.145/dashboardQA/agv/gmotareo/get/agv2023/GetHarvestGroup.php?iddatabase=AGVTEAM_TEST&iddatabase2=AGROVISIONCORP", 1));

    }
    public List<ULR> getListaUrl() {
        return listaUrl;
    }
    public void setListaUrl(List<ULR> listaUrl) {
        this.listaUrl = listaUrl;
    }
}