package com.example.myapplication.Cliente;


import com.example.myapplication.Service.Service;

public class Url {
    public static final String URL_001= "http://34.194.71.145/dashboardQA/agv/gmotareo/get/agv2023/";

    public static final String URL_002= "http://gmoplus-backend-qas.agvperu.com/gmoplus_back/";
    public static  final  String URL_003= "http://34.194.71.145/dashboardQA/agv/gmotareo/get/";
    public static final String URL_004 = "http://52.3.85.45/dashboard/agv/gmotareo/get/";

    public static Service Mediador(){
        return  ConsumoRetrofit.getClient(URL_001).create(Service.class);
    }

    public static Service Mediador2(){
        return  ConsumoRetrofit.getClient(URL_002).create(Service.class);
    }
    public static Service Mediador3(){
        return  ConsumoRetrofit.getClient(URL_003).create(Service.class);
    }
    public static Service Mediador5(){
        return  ConsumoRetrofit.getClient(URL_004).create(Service.class);
    }

}
