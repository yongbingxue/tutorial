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

}
