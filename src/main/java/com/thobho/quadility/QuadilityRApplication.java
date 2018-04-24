package com.thobho.quadility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.thobho.quadility.service",
        "com.thobho.quadility.api",
        "com.thobho.quadility.configuration",
        "com.thobho.quadility.aspects",
})
public class QuadilityRApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuadilityRApplication.class, args);
    }
}
