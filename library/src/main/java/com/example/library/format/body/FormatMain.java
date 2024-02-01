package com.example.library.format.body;


import com.example.library.format.model.ULR;

import java.util.List;

public class FormatMain {
    private List<ULR> listaUrl;
    public List<ULR> getListaUrl() {
        return listaUrl;
    }




    public String toString() {
        return "FormatBody: " + this.listaUrl;
    }
    public void setListaUrl(List<ULR> listaUrl) {
        this.listaUrl = listaUrl;
    }

    public FormatMain() {
        // Default constructor
    }

    // Additional constructor to handle List<ULR>

}
