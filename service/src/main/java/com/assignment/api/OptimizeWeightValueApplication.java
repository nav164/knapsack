package com.assignment.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages= {"com.assignment"})
public class OptimizeWeightValueApplication {

    public static void main(String... args) {
        new SpringApplicationBuilder().sources(OptimizeWeightValueApplication.class)
                .run(args);
    }
}
