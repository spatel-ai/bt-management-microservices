package com.bt.management.microservices.horizonsservice.controller;

import java.time.Duration;

import org.springframework.data.mongodb.core.aggregation.DateOperators.Second;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/horizons-service")
public class HorizonsStatusController {

  @GetMapping("/health")
  public String health() {
    System.out.printf("%S GET /horizons-service/health", "Handling");
    return "Horizons Service is running";
  }
}
