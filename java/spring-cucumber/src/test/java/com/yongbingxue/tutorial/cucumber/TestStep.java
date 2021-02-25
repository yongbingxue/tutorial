package com.yongbingxue.tutorial.cucumber;

import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class TestStep extends SpringIntegrationTest {
    private static final Logger logger = LoggerFactory.getLogger(TestStep.class);

    @Autowired
    private TestService testService;

    @When("test")
    public void test() {
        logger.info("test");

    }
}
