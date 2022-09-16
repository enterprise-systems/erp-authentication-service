package com.enterprisesystems.erpauthenticationservice.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.enterprisesystems.erpauthenticationservice.apis.reponses.Notification;
import com.enterprisesystems.erpauthenticationservice.apis.reponses.Token;
import com.enterprisesystems.erpauthenticationservice.apis.requests.AuthRequest;
import com.enterprisesystems.erpauthenticationservice.services.KeycloakAuthService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/auth")
public class KeycloakAuthController {

  @Autowired
  private KeycloakAuthService authService;

  @PostMapping("/login")
  @Operation(summary = "Login", description = "User login to the ERP System")
  public ResponseEntity<Token> login(@RequestBody AuthRequest authReq) {
    Token tokenResponse = authService.login(authReq);
    return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
  }

  @PostMapping("/logout")
  @Operation(summary = "Logout", description = "User login to the ERP System")
  public ResponseEntity<Notification> logout(WebRequest request, @RequestParam("refresh_token") String refreshToken) {
    Notification tokenResponse = authService.logout(request, refreshToken);
    return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
  }

}
