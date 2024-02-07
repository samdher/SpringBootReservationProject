package com.rdmfinal.ReservacionDeMesas_Final.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MesaDTO(
    long id,
    int noPersonas,
    String ubicacion,
    boolean reservada
) {
}
