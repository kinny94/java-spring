package com.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // THIS IS OPTIONAL IF THERE'S ONLY POINTCUT EXPRESSION IN THE CLASS
@Component
public class AopPointCutExpressions {

    @Pointcut("execution(* com.aop.demo.dao.*.*(..))")
    public void forDOAPackages() {}

    // point cut for getters
    @Pointcut("execution(* com.aop.demo.dao.*.get*(..))")
    public void getter() {}

    // point cut for setters
    @Pointcut("execution(* com.aop.demo.dao.*.set*(..))")
    public void setter() {}

    // create a pointcut to include packages but exclude getters and setters
    @Pointcut("forDOAPackages() && !(getter() || setter())")
    public void forDOAPackageNoGettersSetters() {}
}
