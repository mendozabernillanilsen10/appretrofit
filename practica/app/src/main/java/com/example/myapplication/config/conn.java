package com.example.myapplication.config;

import com.example.myapplication.service.Service;

public class conn {
    public static final String URL_001= "http://52.3.85.45/dashboard/agv/gmotareo/get/";

    public static Service Mediador(){
        return  Cliente.getClient(URL_001).create(Service.class);
    }

}
