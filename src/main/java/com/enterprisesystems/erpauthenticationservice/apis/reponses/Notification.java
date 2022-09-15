package com.enterprisesystems.erpauthenticationservice.apis.reponses;

import java.io.Serializable;
import java.time.ZonedDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {

  private static final long serialVersionUID = -5828101164006114538L;
  
  @Schema(description = "Time", defaultValue = "2022-09-15T13:43:24.879068+07:00")
  private ZonedDateTime time;

  @Schema(description = "Message")
  private String message;

}
