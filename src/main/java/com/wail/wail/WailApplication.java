package com.wail.wail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WailApplication {

    public static void main(String[] args) {
        SpringApplication.run(WailApplication.class, args);
    }

}
