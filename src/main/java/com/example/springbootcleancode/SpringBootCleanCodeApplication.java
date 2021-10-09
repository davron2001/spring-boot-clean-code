package com.example.springbootcleancode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class SpringBootCleanCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCleanCodeApplication.class, args);
    }

//    @Scheduled(fixedRate = 2000L)
//    public void start(){
//        System.out.println("New Rate " + new Date());
//    }
//
//    @Scheduled(initialDelay = 1000L, fixedDelay = 2000L)
//    public void startDelay(){
//        System.out.println("New Delay " + new Date());
//    }
//
//    @Scheduled(cron = "0 30  9 * * *")
//    public void startCron(){
//        System.out.println("New startCron " + new Date());
//    }

}
