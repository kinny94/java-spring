package com.dependency.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Constructor: " + this.getClass().getSimpleName());
    }

    @PostConstruct
    public void init() {
        System.out.println("In init method: " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("In destroy method: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 14 minutes :-)";
    }
}
