package com.example.myapplication.Cliente;


import com.example.myapplication.Service.Service;

import retrofit2.http.PUT;

public class conn {
    public static final String URL_001= "http://34.194.71.145/dashboardQA/agv/gmotareo/get/agv2023/";

    public static  final  String URL_003= "http://34.194.71.145/dashboardQA/agv/gmotareo/get/";
    public static final String URL_004 = "http://52.3.85.45/dashboard/agv/gmotareo/get/";



    public static Service Mediador(){
        return  Cliente.getClient(URL_001).create(Service.class);
    }

    public static Service Mediador3(){
        return  Cliente.getClient(URL_003).create(Service.class);
    }
    public static Service Mediador5(){
        return  Cliente.getClient(URL_004).create(Service.class);
    }

}
