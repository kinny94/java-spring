package com.dependency.demo.common;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("Constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a 5k under 35 mins!";
    }
}
