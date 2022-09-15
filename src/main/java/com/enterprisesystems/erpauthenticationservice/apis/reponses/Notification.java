package com.enterprisesystems.erpauthenticationservice.apis.reponses;

import java.io.Serializable;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {

  private static final long serialVersionUID = -5828101164006114538L;
  
  private ZonedDateTime time;

  private String message;

}
