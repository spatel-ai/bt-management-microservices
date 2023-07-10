package com.bt.management.microservices.horizonsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horizons-service")
public class HorizonServiceController {

  @GetMapping("/")
  public String getResponseString() {
    System.out.println("calling from horizons");
    return "<h1>Latest Version which you are using of Horizons service v2 HORIZON CONTROLLER 2</h1>";
  }
}
