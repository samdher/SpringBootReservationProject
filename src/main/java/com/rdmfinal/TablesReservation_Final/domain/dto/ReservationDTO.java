package com.rdmfinal.TablesReservation_Final.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ReservationDTO(
    Long id,
    Long idTableBench,
    String client,
    Date dateReservation,
    int duration,
    String status
) {
}
