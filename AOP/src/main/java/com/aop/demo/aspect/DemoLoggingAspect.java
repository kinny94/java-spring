package com.aop.demo.aspect;

import com.aop.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    @Around("execution(* com.aop.demo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {

        String methods = joinPoint.getSignature().toShortString();
        System.out.println("\n ====> Executing @Around " + methods);

        long begin = System.currentTimeMillis();
        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("Duration: " + duration / 1000.0 + " ms");
        return result;
    }

    @After("execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))")
    public void afterFinally(JoinPoint joinPoint) {
        String methods = joinPoint.getSignature().toShortString();
        System.out.println("\n ====> Executing @After (finally) " + methods);
    }

    @AfterThrowing(
            pointcut = "execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrpwingFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {
        String methods = joinPoint.getSignature().toShortString();
        System.out.println("\n ====> Executing @AfterThrowing " + methods);
        System.out.println("\n ====> Result " + exception);
    }

    @AfterReturning(
            pointcut = "execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccount(JoinPoint joinPoint, List<Account> result) {
        String methods = joinPoint.getSignature().toShortString();
        System.out.println("\n ====> Executing @AfterReturning " + methods);
        System.out.println("\n ====> Result " + result);

        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    /*
    @Before("execution(public void com.aop.demo.dao.AccountDAO.addAccount())")
    @Before("execution(* add*(com.aop.demo.Account, ..))")
     */
    @Before("com.aop.demo.aspect.AopPointCutExpressions.forDOAPackageNoGettersSetters()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("Executing @Before advice on account addAccount()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method Signature: " + methodSignature);

        // display the method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg: " + arg);
            if (arg instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) arg;
                System.out.println("Account: " + account.getName());
                System.out.println("Level: " + account.getLevel());
            }
        }
    }


}
