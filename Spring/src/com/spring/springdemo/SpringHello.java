package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHello {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve the bean from the spring container
        Coach coach = context.getBean("myCoach", Coach.class);

        // call the method on the bean
        System.out.println(coach.getDailyWorkout());

        // close the context
        context.close();
    }
}
