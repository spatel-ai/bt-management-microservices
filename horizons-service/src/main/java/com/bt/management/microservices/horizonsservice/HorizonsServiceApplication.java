package com.bt.management.microservices.horizonsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HorizonsServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(HorizonsServiceApplication.class, args);
  }
}
