package com.example.myapplication.url;


import com.example.library.format.model.ULR;

import java.util.ArrayList;
import java.util.List;

public class ListaUrl  {
    private List<ULR> listaUrl;
    public ListaUrl() {
        this.listaUrl = new ArrayList<>();
        listaUrl.add(new ULR("http://34.194.71.145/dashboardQA/agv/gmotareo/get/GetQuerygg.php?iddatabase=AGVTEAM_TEST&query=exec MobileGetListParamMateriaPrima 'AGROVISIONCORP', '001',1;", 1));
        listaUrl.add(new ULR("https://www.ejemplo.com/ssss2", 1));
        listaUrl.add(new ULR("https://www..com/3sss", 5, "token"));
        listaUrl.add(new ULR("https://www.ejemplo.com/4ssss", 3, "token", "tabla"));
        listaUrl.add(new ULR("https://www..com/getApiproductos5", 1, "token", "tabla"));
    }
    public List<ULR> getListaUrl() {
        return listaUrl;
    }
    public void setListaUrl(List<ULR> listaUrl) {
        this.listaUrl = listaUrl;
    }
}