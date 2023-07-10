package com.bt.management.microservices.studentsconnectservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students-connect-service")
public class StudentConnectController {

  @GetMapping("/")
  public String getResponse() {
    System.out.println("/////////////////////////////////");
    System.out.println("calling from connect");
    return "<h1>Shalini is from Student connect servicde</h1>";
  }
}
