package com.yongbingxue.tutorial.springaop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yongbingxue.tutorial.springaop.annotation.AnnotationAOP;

@RestController
public class SpringAOPController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AnnotationAOP
    @GetMapping("/annotation")
    public void annotationAOP() {
        logger.info("annotation");
    }

    @GetMapping("/any-public-method-in-module")
    public void anyPublicMethod() {
        logger.info("anyPublicMethod");
    }

}
