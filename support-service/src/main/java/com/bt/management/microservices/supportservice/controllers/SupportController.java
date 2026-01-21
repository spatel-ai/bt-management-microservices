package com.bt.management.microservices.supportservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/support-service")
public class SupportController {

  private static final Logger log = LoggerFactory.getLogger(SupportController.class);

  @GetMapping("/")
  public String getSupport() {
    log.info("Handling GET /support-service/");
    return "calling from support";
  }

  @GetMapping("/health")
  public String health() {
    log.info("Handling GET /support-service/health");
    return "Support Service is running";
  }
}
