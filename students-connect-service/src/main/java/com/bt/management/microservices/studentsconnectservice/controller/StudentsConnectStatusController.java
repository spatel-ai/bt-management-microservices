package com.bt.management.microservices.studentsconnectservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students-connect-service")
public class StudentsConnectStatusController {

  private static final Logger log = LoggerFactory.getLogger(
    StudentsConnectStatusController.class
  );

  @GetMapping("/health")
  public String health() {
    log.info("Handling GET /students-connect-service/health");
    return "Students Connect Service is running";
  }
}
