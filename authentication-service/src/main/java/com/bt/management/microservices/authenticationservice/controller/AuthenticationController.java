package com.bt.management.microservices.authenticationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication-service")
public class AuthenticationController {

  @GetMapping("/")
  public String getResponse() {
    System.out.println(" From api %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    return "<h1>Latest Version which you are using of authentication service</h1>";
  }
}
