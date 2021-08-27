package com.spring.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() { }

    public TrackCoach(FortuneService theFortuneService) { fortuneService = theFortuneService; }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do it: " +  fortuneService.getFortune();
    }
}
