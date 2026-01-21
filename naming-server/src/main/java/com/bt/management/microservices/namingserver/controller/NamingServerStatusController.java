package com.bt.management.microservices.namingserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/naming-server")
public class NamingServerStatusController {

  private static final Logger log = LoggerFactory.getLogger(
    NamingServerStatusController.class
  );

  @GetMapping("/health")
  public String health() {
    log.info("Handling GET /naming-server/health");
    return "Naming Server is running";
  }
}
