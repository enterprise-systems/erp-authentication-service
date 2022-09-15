package com.enterprisesystems.erpauthenticationservice.apis.requests;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  @Schema(name = "username", title = "Username", description = "Username", defaultValue = "test")
  private String username;

  @Schema(name = "password", title = "Password", description = "Password", defaultValue = "test")
  private String password;

}
