package com.yongbingxue.tutorial.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspects {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(com.yongbingxue.tutorial.springaop.annotation.AnnotationAOP)")
    public void annotationAdvice() {
        logger.info("annotationAdvice");
    }

    @Around("execution(public * com.yongbingxue.tutorial.springaop..*.*(..))")
    public Object anyPublicOperationInSpringAOP(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("before anyPublicOperationInSpringAOP");

        Object retValue = proceedingJoinPoint.proceed();

        logger.info("after anyPublicOperationInSpringAOP");

        return retValue;
    }
}
