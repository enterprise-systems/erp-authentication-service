package com.enterprisesystems.erpauthenticationservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.enterprisesystems.erpauthenticationservice.apis.reponses.Notification;
import com.enterprisesystems.erpauthenticationservice.apis.reponses.Token;
import com.enterprisesystems.erpauthenticationservice.apis.requests.AuthRequest;
import com.enterprisesystems.erpauthenticationservice.constants.AuthConstant;
import com.enterprisesystems.erpauthenticationservice.exceptions.ApplicationException;
import com.enterprisesystems.erpauthenticationservice.services.KeycloakAuthService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KeycloakAuthServiceImpl implements KeycloakAuthService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${login-url}")
  private String loginUrl;

  @Value("${keycloak.resource}")
  private String clientId;

  @Value("${keycloak.credentials.secret}")
  private String clientSceret;

  @Override
  public Token login(AuthRequest authReq) {

    Token token = new Token();
    MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
    body.add(AuthConstant.USERNAME, authReq.getUsername());
    body.add(AuthConstant.PASSWORD, authReq.getPassword());
    body.add(AuthConstant.GRANT_TYPE, "password");
    body.add(AuthConstant.CLIENT_ID, clientId);
    body.add(AuthConstant.CLIENT_SECRET, clientSceret);
    body.add(AuthConstant.SCOPE, "openid");

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body,
        httpHeaders);

    try {
      ResponseEntity<Token> response = restTemplate.postForEntity(loginUrl, entity, Token.class);
      if (HttpStatus.OK.equals(response.getStatusCode())) {
        token = response.getBody();
      }
    } catch (Exception e) {
      log.error("ERROR Call API: {}", e.getLocalizedMessage());
      throw new ApplicationException("Login error! Pleacheck username or password",
          HttpStatus.UNAUTHORIZED);
    }
    return token;
  }

  @Override
  public Notification logout(String token) {
    return null;
  }

}
