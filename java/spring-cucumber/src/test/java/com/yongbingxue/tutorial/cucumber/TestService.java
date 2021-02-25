package com.yongbingxue.tutorial.cucumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    @PostConstruct
    public void init() {
        logger.info("init TestService");
        throw new RuntimeException("Exception!!!");
    }
}
