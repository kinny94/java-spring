package com.spring.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class AnnotationBeanscopeDemo {

    public static void main(String[] args) {

        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve the bean from the spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean result = (coach == alphaCoach);

        // print the results
        System.out.println("\n Pointing to the same object: " + result);
        System.out.println("\n Memory location for coach: " + coach);
        System.out.println("\n Memory location for alphaCoach: " + alphaCoach);

        context.close();
    }

}
