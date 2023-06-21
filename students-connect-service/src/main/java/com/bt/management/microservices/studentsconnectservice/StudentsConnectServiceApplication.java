package com.bt.management.microservices.studentsconnectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentsConnectServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(StudentsConnectServiceApplication.class, args);
  }
}
