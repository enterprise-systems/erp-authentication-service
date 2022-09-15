package com.enterprisesystems.erpauthenticationservice.apis.reponses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Token implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("access_token")
  @Schema(title = "Access Token", description = "Access Token")
  private String accessToken;

  @JsonProperty("expires_in")
  @Schema(title = "Expires In", description = "Expires In")
  private long expiresIn;

  @JsonProperty("refresh_expires_in")
  @Schema(title = "Refresh Expires In", description = "Refresh Expires In")
  private long refreshExpiresIn;

  @JsonProperty("refresh_token")
  @Schema(title = "Refresh Token", description = "Refresh Token")
  private String refreshToken;

  @JsonProperty("token_type")
  @Schema(title = "Token Type", description = "Token Type")
  private String tokenType;

  @JsonProperty("id_token")
  @Schema(title = "ID Token", description = "ID Token")
  private String idToken;

  @JsonProperty("not-before-policy")
  @Schema(title = "Not Before Policy", description = "Not Before Policy")
  private long notBeforePolicy;

  @JsonProperty("session_state")
  @Schema(title = "Session State", description = "Session State")
  private String sessionState;

  @Schema(title = "Scope", description = "Scope")
  private String scope;
  
}
