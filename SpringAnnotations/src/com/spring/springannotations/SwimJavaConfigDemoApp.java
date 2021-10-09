package com.spring.springannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);

        // get the bean from the spring container
        Coach coach = context.getBean("swimCoach", Coach.class);

        // call a method on the bean
        System.out.println(coach.getDailyWorkout());

        // call the method to get the daily fortune
        System.out.println(coach.getDailyFortune());

        // close the container
        context.close();
    }
}
