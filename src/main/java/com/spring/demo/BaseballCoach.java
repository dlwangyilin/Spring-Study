package com.spring.demo;

public class BaseballCoach implements Coach{

    private final FortuneService fortuneService;

    /* define a constructor for dependency injection */

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
