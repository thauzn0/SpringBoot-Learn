package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.printf("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1km  as a warm up";
    }
}
