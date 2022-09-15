package com.enterprisesystems.erpauthenticationservice.apis.controllers;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprisesystems.erpauthenticationservice.apis.reponses.Notification;

@RestController
@RequestMapping("/auth")
public class CommonController {
  
  @GetMapping("/helth")
  public ResponseEntity<Notification> helthCheck() {
    return new ResponseEntity<>(new Notification(ZonedDateTime.now(), "UP"), HttpStatus.OK);
  }

}
