package com.example.myapplication.Cliente;


import com.example.myapplication.Service.Service;

import retrofit2.http.PUT;

public class conn {
    public static final String URL_001= "http://34.194.71.145/dashboardQA/agv/gmotareo/get/agv2023/";

    public static Service Mediador(){
        return  Cliente.getClient(URL_001).create(Service.class);
    }



}
