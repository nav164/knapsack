package com.assingment.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages= {"com.assingment"})
public class OptimizeWeightValueApplication {

	public static void main(String... args) {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(OptimizeWeightValueApplication.class)
                .run(args);
    }
}
