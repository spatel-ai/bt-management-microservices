package com.bt.management.microservices.authenticationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.management.microservices.authenticationservice.config.UserConfiguration;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/authentication-service")
@RequiredArgsConstructor
public class AuthenticationController {
  private final UserConfiguration userConfig;

  private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

  @GetMapping("/")
  public String getResponse() {
    log.info("Handling GET /authentication-service/");
    log.info("{}", userConfig.toString());
    System.out.println(
        " From api %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    return "hi from Authentication service";
  }

  @GetMapping("/health")
  public String health() {
    log.info("Handling GET /authentication-service/health");
    return "Authentication Service is running";
  }
}
