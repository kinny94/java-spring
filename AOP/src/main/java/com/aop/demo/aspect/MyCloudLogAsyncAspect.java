package com.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.aop.demo.aspect.AopPointCutExpressions.forDOAPackageNoGettersSetters()")
    public void logToCloudAsync() {
        System.out.println("Logging to Cloud");
    }
}
