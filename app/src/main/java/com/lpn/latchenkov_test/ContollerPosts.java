package com.lpn.latchenkov_test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Paul on 31.10.2017.
 */

public class ContollerPosts {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static JsonPlaceHolder getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        return jsonPlaceHolder;
    }
}
