package com.yongbingxue.tutorial.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yongbingxue.tutorial.springaop.annotation.AnnotationAOP;

@Aspect
@Component
public class CustomAspects {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(annotationAOP)")
    public void annotationAdvice(AnnotationAOP annotationAOP) {
        logger.info("annotationAdvice");

        String value = annotationAOP.value();
        logger.info("value : {}", value);
    }

    @After("@annotation(annotationAOP)")
    public void afterAnnotationAdvice(AnnotationAOP annotationAOP) {
        logger.info("afterAnnotationAdvice");

        String value = annotationAOP.value();
        logger.info("value : {}", value);
    }

    @Around("execution(public * com.yongbingxue.tutorial.springaop..*.*(..))")
    public Object anyPublicOperationInSpringAOP(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("before anyPublicOperationInSpringAOP");

        Object retValue = proceedingJoinPoint.proceed();

        logger.info("after anyPublicOperationInSpringAOP");

        return retValue;
    }

    @Around("@annotation(com.yongbingxue.tutorial.springaop.annotation.AnnotationAOP)")
    public Object aroundAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("before aroundAnnotation");

        Object retValue = proceedingJoinPoint.proceed();

        logger.info("after aroundAnnotation");

        return retValue;
    }
}
