package com.bt.management.microservices.authenticationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.management.microservices.authenticationservice.config.UserConfiguration;
import com.bt.management.microservices.authenticationservice.helpers.EmailChannel;
import com.bt.management.microservices.authenticationservice.helpers.NotifyChannel;
import com.bt.management.microservices.authenticationservice.helpers.NotifyTypes;
import com.bt.management.microservices.authenticationservice.helpers.PushChannel;
import com.bt.management.microservices.authenticationservice.helpers.SmsChannel;
import com.bt.management.microservices.authenticationservice.notification.Notification;

@RestController
@RequestMapping("/authentication-service")
public class AuthenticationController {

  @Autowired
  private UserConfiguration userConfig;

  @Autowired
  @SmsChannel
  private Notification smsNotification;

  @Autowired
  @EmailChannel
  private Notification emailNotification;

  @Autowired
  @PushChannel
  private Notification pushNotification;

  private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

  @GetMapping("/")
  public String getResponse() {
    log.info("Handling GET /authentication-service/");
    log.info("{}", userConfig.toString());
    emailNotification.send("HI Shubham");
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
