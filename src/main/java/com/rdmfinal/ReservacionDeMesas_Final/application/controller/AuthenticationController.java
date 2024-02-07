package com.rdmfinal.ReservacionDeMesas_Final.application.controller;

import com.rdmfinal.ReservacionDeMesas_Final.application.exception.DemoSecurityException;
import com.rdmfinal.ReservacionDeMesas_Final.application.service.AuthenticationService;
import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.AuthenticationDto;
import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public record AuthenticationController(
  AuthenticationService authenticationService
) {

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody UserDto userDto) throws DemoSecurityException {
    String token = authenticationService.register(userDto);
    return new ResponseEntity<>(token, HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthenticationDto authenticationDto) throws DemoSecurityException {
    String token = authenticationService.login(authenticationDto);
    return new ResponseEntity<>(token, HttpStatus.OK);
  }

}
