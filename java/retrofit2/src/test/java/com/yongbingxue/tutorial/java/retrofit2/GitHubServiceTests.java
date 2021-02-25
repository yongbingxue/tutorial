package com.yongbingxue.tutorial.java.retrofit2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import retrofit2.Response;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {GitHubService.class, ObjectMapper.class})
class GitHubServiceTests {
    private static final Logger logger = LoggerFactory.getLogger(GitHubServiceTests.class);

    @Autowired
    private GitHubService gitHubService;

    @Test
    void test() {
        logger.info("test");
        gitHubService.getApi();
    }

    @Test
    void test_get200() {
        logger.info("test_get200");
        Response<String> response = gitHubService.get200();
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertEquals("200", response.body());
        Assertions.assertNull(response.errorBody());
    }

    @Test
    void test_get403() throws IOException {
        logger.info("test_get403");
        Response<String> response = gitHubService.get403();
        Assertions.assertFalse(response.isSuccessful());
        Assertions.assertNull(response.body());
        Assertions.assertEquals("error message 403", response.errorBody().string());
    }
}
