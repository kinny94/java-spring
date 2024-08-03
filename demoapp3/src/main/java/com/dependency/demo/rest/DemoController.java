package com.dependency.demo.rest;

import com.dependency.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @Autowired
    public void setCoach(@Qualifier("baseballCoach") Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
         return myCoach.getDailyWorkout();
    }

}
