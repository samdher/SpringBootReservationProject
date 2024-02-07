package com.rdmfinal.ReservacionDeMesas_Final.application.exception;

import lombok.Getter;
import com.rdmfinal.ReservacionDeMesas_Final.application.lasting.EMessage;
import org.springframework.http.HttpStatus;

@Getter
public class DemoSecurityException extends Exception{

  private final HttpStatus status;
  private final String message;

  public DemoSecurityException(EMessage eMessage){
    this.status = eMessage.getStatus();
    this.message = eMessage.getMessage();
  }

}
