package com.yongbingxue.tutorial.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAOPAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(com.yongbingxue.tutorial.springaop.annotation.AnnotationAOP)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("abc");
        return joinPoint.proceed();
    }
}
