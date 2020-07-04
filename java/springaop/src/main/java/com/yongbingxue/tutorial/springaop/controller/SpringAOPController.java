package com.yongbingxue.tutorial.springaop.controller;

import com.yongbingxue.tutorial.springaop.annotation.AnnotationAOP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAOPController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AnnotationAOP
    @GetMapping("/annotation")
    public void annotation() {
        logger.info("annotation");
    }

}
