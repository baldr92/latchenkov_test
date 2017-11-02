package com.lpn.latchenkov_test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Paul on 31.10.2017.
 */

public interface Api {
    @GET("/posts{id}")
    Post getPost(@Path("id") int id);
}
