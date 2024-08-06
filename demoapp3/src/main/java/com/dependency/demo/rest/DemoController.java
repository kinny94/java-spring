package com.dependency.demo.rest;

import com.dependency.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;
    private Coach baseball;
    private Coach baseball2;
    private Coach swimCoach;


    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach anAnotherCoach,
            @Qualifier("baseballCoach") Coach aBaseballCoach,
            @Qualifier("baseballCoach") Coach anotherBaseBallCoach,
            @Qualifier("customSwimCoachId") Coach aSwimCoach
    ) {
        System.out.println("Constructor: " + this.getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = anAnotherCoach;
        baseball = aBaseballCoach;
        baseball2 = anotherBaseBallCoach;
        swimCoach = aSwimCoach;
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

    @GetMapping("/check")
    public String checkBeanScope() {
        return "Comparing cricket beans : myCoach == anotherCoach : " + (anotherCoach == myCoach) + "\n" + "Comparing baseball beans : bsaeball == baseball2 : " + (baseball == baseball2);

    }

}
