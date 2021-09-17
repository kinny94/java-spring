package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        // load the spring conf file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve the bean from the spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if they are the same
        boolean result = (theCoach == alphaCoach);

        System.out.println("\n Pointing to the same object: " + result);
        System.out.println("\n Memory location for theCoach: " + theCoach);
        System.out.println("\n Memory location for alphaCoach: " + alphaCoach);

        // close the context
        context.close();
    }
}
