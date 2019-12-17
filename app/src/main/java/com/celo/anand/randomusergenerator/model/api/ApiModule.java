package com.celo.anand.randomusergenerator.model.api;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    public static ApiInterface getApiInterface() {
        return new Retrofit.Builder().
                baseUrl("https://randomuser.me/api/1.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiInterface.class);
    }
}
