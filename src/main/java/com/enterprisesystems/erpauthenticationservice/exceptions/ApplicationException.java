package com.enterprisesystems.erpauthenticationservice.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final HttpStatus httpStatus;

  public ApplicationException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

}
