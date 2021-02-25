package com.yongbingxue.tutorial.java.retrofit2.internal;

import com.fasterxml.jackson.databind.JsonNode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GithubServiceInternal {
    @Headers({
            "Content-Type: application/json"
    })
    @GET("/")
    Call<JsonNode> getApi();

    @Headers({
            "Content-Type: application/json"
    })
    @GET("/200")
    Call<String> get200();

    @Headers({
            "Content-Type: application/json"
    })
    @GET("/403")
    Call<String> get403();

}
