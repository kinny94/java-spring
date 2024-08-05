package com.dependency.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("Constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backhand!!";
    }
}
