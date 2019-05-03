package ren.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * This is the main class for Cloud Gateway service.
 * Run this after all the other services.
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableSwagger2 requires additional config which is not fully available yet, can be 
public class GatewayServiceApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

}
