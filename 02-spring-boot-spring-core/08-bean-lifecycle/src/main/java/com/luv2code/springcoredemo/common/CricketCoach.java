package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): "+ getClass().getSimpleName());
    }
    //define our destroy method
    @PreDestroy
    public void doMyCleanuppStuff(){
        System.out.println("In doMyCleanuppStuff(): "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 min.!! :-)";
    }

}
