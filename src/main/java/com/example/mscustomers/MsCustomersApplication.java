package com.example.mscustomers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsCustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCustomersApplication.class, args);
    }

}
