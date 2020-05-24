package com.yongbingxue.tutorial.java.retrofit2;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yongbingxue.tutorial.java.retrofit2.internal.GithubServiceInternal;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class GitHubService {
    private static final Logger logger = LoggerFactory.getLogger(GitHubService.class);

    private GithubServiceInternal service;

    private final ObjectMapper objectMapper;

    public GitHubService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build();

        service = retrofit.create(GithubServiceInternal.class);
    }

    public JsonNode getApi() {
        logger.info("getApi");
        Response<JsonNode> response = null;
        try {
            response = service.getApi().execute();
        } catch (IOException e) {
            logger.error("getApi exception", e);
        }
        return response == null ? objectMapper.createObjectNode() : response.body();
    }

}
