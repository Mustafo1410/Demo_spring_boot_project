package com.example.Demo_spring_boot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

   /* @Scheduled(cron = "* * * * * *")
    public void schedule() {
        String format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date());
        System.out.println(format);
    }*/
}
