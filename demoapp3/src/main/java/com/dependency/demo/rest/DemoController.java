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
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("Constructor: " + this.getClass().getSimpleName());
        myCoach = theCoach;
    }

    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach coach) {
        System.out.println("In setCoach: " + this.getClass().getSimpleName());
        myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
         return myCoach.getDailyWorkout();
    }
}
