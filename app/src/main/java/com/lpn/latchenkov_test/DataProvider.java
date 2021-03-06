package com.lpn.latchenkov_test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Paul on 31.10.2017.
 */

public class DataProvider {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private Api api;

    public void initApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(Api.class);
    }

    public Api getApi() {
        return api;
    }
}
