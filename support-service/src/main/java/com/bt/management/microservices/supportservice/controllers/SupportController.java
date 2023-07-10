package com.bt.management.microservices.supportservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/support-service")
public class SupportController {

  @GetMapping("/")
  public String getSupport() {
    return "<h1>Latest Version which you are using of support service SUPPORT CONTROLLERS 2</h1>";
  }
}
