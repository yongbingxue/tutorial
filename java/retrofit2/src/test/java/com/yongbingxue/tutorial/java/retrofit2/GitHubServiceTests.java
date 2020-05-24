package com.yongbingxue.tutorial.java.retrofit2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { GitHubService.class, ObjectMapper.class })
class GitHubServiceTests {
    private static final Logger logger = LoggerFactory.getLogger(GitHubServiceTests.class);

    @Autowired
    private GitHubService gitHubService;

    @Test
    void test() {
        logger.info("test");

        Assertions.assertEquals("https://api.github.com/user",
            gitHubService.getApi().get("current_user_url").asText());
    }
}
