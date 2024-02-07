package com.rdmfinal.ReservacionDeMesas_Final.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rdmfinal.ReservacionDeMesas_Final.application.lasting.ERole;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(
  Integer id,
  String firstName,
  String lastName,
  String email,
  String password,
  Boolean enable,
  ERole role
) {
}
