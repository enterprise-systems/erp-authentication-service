package com.enterprisesystems.erpauthenticationservice.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.enterprisesystems.erpauthenticationservice.apis.reponses.Notification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionsHandler {
  
  @ExceptionHandler(value = { ApplicationException.class })
  public ResponseEntity<Notification> handleUserServiceException(ApplicationException ex, WebRequest request) {
    Notification notification = Notification.builder().time(ZonedDateTime.now()).message(ex.getMessage()).build();
    log.error(ex.getMessage());
    return new ResponseEntity<>(notification, ex.getHttpStatus());
  }
  
}
