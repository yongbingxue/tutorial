package com.yongbingxue.tutorial.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringDemoApplication.class)
public class SpringIntegrationTest {

}