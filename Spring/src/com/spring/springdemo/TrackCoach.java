package com.spring.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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

    // add an init method
    public void doMyStartStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    // add a destroy method
    public void doMyCleanUpStuff() {
        System.out.println("TrackCoach: inside method doMyCleanUpStuff");
    }
}
