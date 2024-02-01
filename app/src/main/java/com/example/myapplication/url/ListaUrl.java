package com.example.myapplication.url;


import com.example.library.format.model.ULR;

import java.util.ArrayList;
import java.util.List;

public class ListaUrl  {
    private List<ULR> listaUrl;
    public ListaUrl() {
        this.listaUrl = new ArrayList<>();
        listaUrl.add(new ULR("https://www.ejemplo.comxY/getApiproductos", 1));
        listaUrl.add(new ULR("https://www.ejemplo.com/getApiproductos", 1));
        listaUrl.add(new ULR("https://www.ejemplo.com/getApiproductos", 1, "token"));
        listaUrl.add(new ULR("https://www.ejemplo.com/getApiproductos", 1, "token", "tabla"));
        listaUrl.add(new ULR("https://www.ejemplo.com/getApiproductos", 1, "token", "tabla"));
    }
    public List<ULR> getListaUrl() {
        return listaUrl;
    }
    public void setListaUrl(List<ULR> listaUrl) {
        this.listaUrl = listaUrl;
    }
}