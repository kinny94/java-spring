package com.spring.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    //define a default constructor
    public TennisCoach() {
        System.out.println(">> Tennis Coach: inside default constructor");
    }

//    // define a setter method
//    @Autowired
//    public void setFortuneService(FortuneService theFortuneService) {
//        System.out.println(">> Tennis Coach: inside setter method");
//        fortuneService = theFortuneService;
//    }

//    // define a method
//    @Autowired
//    public void doSomeCrazyStuff(FortuneService theFortuneService) {
//        System.out.println(">> Tennis Coach: inside doSomeCrazyStuff method");
//        fortuneService = theFortuneService;
//    }

//    @Autowired
//    public TennisCoach(FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }

    // Field Injection

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley!!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
