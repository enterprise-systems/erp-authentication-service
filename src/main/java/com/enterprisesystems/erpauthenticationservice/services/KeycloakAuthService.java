package com.enterprisesystems.erpauthenticationservice.services;

import org.springframework.web.context.request.WebRequest;

import com.enterprisesystems.erpauthenticationservice.apis.reponses.Notification;
import com.enterprisesystems.erpauthenticationservice.apis.reponses.Token;
import com.enterprisesystems.erpauthenticationservice.apis.requests.AuthRequest;

public interface KeycloakAuthService {

  Token login(AuthRequest authReq);

  Notification logout(WebRequest request, String refreshToken);

}
