package com.spring.springdemo;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    // create a no arg constructor
    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    // setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside the setter method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
