package com.bt.management.microservices.authenticationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.management.microservices.authenticationservice.config.UserConfiguration;
import com.bt.management.microservices.authenticationservice.helpers.NotifyChannel;
import com.bt.management.microservices.authenticationservice.helpers.NotifyTypes;
import com.bt.management.microservices.authenticationservice.notification.Notification;
import com.bt.management.microservices.authenticationservice.service.AuthenticationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/authentication-service")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authService;
  private final UserConfiguration userConfig;
  private final Notification smsNotification;
  private final Notification emailNotification;
  private final Notification pushNotification;


  @GetMapping("/")
  public String getResponse() {
    log.info("Handling GET /authentication-service/");
    log.info("{}", userConfig.toString());
    emailNotification.send("Hi Shubham");
    smsNotification.send("Hi Shubham");
    pushNotification.send("Hi Shubham");
    return "hi from Authentication service";
  }

  @GetMapping("/test-response")
  public String getCircuitBreakerResponse() {
    log.info("Handling GET /authentication-service/");
    return authService.getStatusOfHorizonService();
  }

  @GetMapping("/health")
  public String health() {
    log.info("Handling GET /authentication-service/health");
    return "Authentication Service is running";
  }
}
