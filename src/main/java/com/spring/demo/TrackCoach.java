package com.spring.demo;

public class TrackCoach implements Coach{

    private final FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "trackCoach";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it" + fortuneService.getFortune();
    }
}
