package com.dependency.demo.common;

public class SwinCoach implements Coach {

    public SwinCoach() {
        System.out.println("Constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Do 5 laps or 1000 meters for warmups";
    }
}
