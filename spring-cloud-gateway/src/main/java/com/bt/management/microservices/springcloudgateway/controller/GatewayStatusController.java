package com.bt.management.microservices.springcloudgateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class GatewayStatusController {

  private static final Logger log = LoggerFactory.getLogger(GatewayStatusController.class);

  @GetMapping("/health")
  public String health() {
    log.info("Handling GET /gateway/health");
    return "Spring Cloud Gateway is running";
  }
}
