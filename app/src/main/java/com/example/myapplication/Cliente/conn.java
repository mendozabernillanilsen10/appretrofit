package com.example.myapplication.Cliente;


import com.example.myapplication.Service.Service;

public class conn {
    public static final String URL_001= "http://52.3.85.45/dashboard/agv/gmotareo/get/";

    public static Service Mediador(){
        return  Cliente.getClient(URL_001).create(Service.class);
    }

}
