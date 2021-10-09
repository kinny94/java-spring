package com.spring.springannotations;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as a warm up!!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
