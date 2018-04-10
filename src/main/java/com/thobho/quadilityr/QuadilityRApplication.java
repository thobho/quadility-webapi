package com.thobho.quadilityr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.thobho.quadilityr.service",
        "com.thobho.quadilityr.api",
        "com.thobho.quadilityr.configuration",
        "com.thobho.quadilityr.aspects",
})
public class QuadilityRApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuadilityRApplication.class, args);
    }
}
