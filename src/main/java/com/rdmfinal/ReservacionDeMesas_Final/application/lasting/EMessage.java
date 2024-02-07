package com.rdmfinal.ReservacionDeMesas_Final.application.lasting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EMessage {

  DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "The data was not found"),
  MESA_NOT_FOUND(HttpStatus.NOT_FOUND, "Mesa No Encontrada"),
  MESA_NOT_AVAILABLE(HttpStatus.NOT_FOUND, "Mesa No Disponible"),
  USER_NOT_FOUND(HttpStatus.NOT_FOUND, "The User was not found"),
  USER_NOT_CREATED(HttpStatus.NOT_FOUND, "The User was not able to created, duplicated key"),
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "The user was not Authorized to access at the application");

  private final HttpStatus status;
  private final String message;


}
