package com.bt.management.microservices.authenticationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.management.microservices.authenticationservice.config.UserConfiguration;
import com.bt.management.microservices.authenticationservice.notification.Notification;
import com.bt.management.microservices.authenticationservice.notification.NotifyChannel;
import com.bt.management.microservices.authenticationservice.notification.NotifyTypes;

@RestController
@RequestMapping("/authentication-service")
public class AuthenticationController {

  @Autowired
  private UserConfiguration userConfig;

  @Autowired
  @NotifyChannel(value = NotifyTypes.EMAIL)
  private Notification emailNotification;

  @Autowired
  @NotifyChannel(value = NotifyTypes.SMS)
  private Notification smsNotification;

  @Autowired
  @NotifyChannel(value = NotifyTypes.PUSH)
  private Notification pushNotification;

  private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

  @GetMapping("/")
  public String getResponse() {
    log.info("Handling GET /authentication-service/");
    log.info("{}", userConfig.toString());
    emailNotification.send("Hi Shubham");
    smsNotification.send("Hi Shubham");
    pushNotification.send("Hi Shubham");
    return "hi from Authentication service";
  }

  @GetMapping("/health")
  public String health() {
    log.info("Handling GET /authentication-service/health");
    return "Authentication Service is running";
  }
}
