package com.bt.management.microservices.horizonsservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horizons-service")
public class HorizonsStatusController {

  private static final Logger log = LoggerFactory.getLogger(HorizonsStatusController.class);

  @GetMapping("/health")
  public String health() {
    log.info("Handling GET /horizons-service/health");
    return "Horizons Service is running";
  }
}
