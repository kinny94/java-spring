package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemo {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve the bean from the spring container
        CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);

        // call the method on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        // close the context
        context.close();
    }
}
