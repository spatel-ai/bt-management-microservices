package com.bt.management.microservices.authenticationservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.management.microservices.authenticationservice.config.UserConfiguration;
import com.bt.management.microservices.authenticationservice.notification.Notification;

@RestController
@RequestMapping("/authentication-service")
public class AuthenticationController {
  private final UserConfiguration userConfig;
  private final Notification notification;

  AuthenticationController(UserConfiguration userConfig, @Qualifier("pushNotification") Notification notification) {
    this.userConfig = userConfig;
    this.notification = notification;
  }

  private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

  @GetMapping("/")
  public String getResponse() {
    log.info("Handling GET /authentication-service/");
    log.info("{}", userConfig.toString());
    System.out.println(notification);
    notification.send();
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
