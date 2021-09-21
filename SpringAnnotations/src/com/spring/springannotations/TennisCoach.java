package com.spring.springannotations;

public class TennisCoach implements  Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley!!";
    }
}
