package com.dependency.demo.rest;

import com.dependency.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public void setCoach(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
         return myCoach.getDailyWorkout();
    }

}
