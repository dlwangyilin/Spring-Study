package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
    public static void main(String[] args) {
        // load spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        // close the context

        CricketCoach anotherCoach = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(anotherCoach.getDailyWorkout());
        System.out.println(anotherCoach.getDailyFortune());
        System.out.println(anotherCoach.getTeam());
        System.out.println(anotherCoach.getEmailAddress());
        context.close();

    }
}
