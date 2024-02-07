package com.rdmfinal.ReservacionDeMesas_Final.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ReservaDTO(
    long id,
    long idMesa,
    String cliente,
    Date fechaReserva,
    int duracion,
    String estado
) {
}
