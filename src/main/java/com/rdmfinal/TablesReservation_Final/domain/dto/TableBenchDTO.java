package com.rdmfinal.TablesReservation_Final.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TableBenchDTO(
    Long id,
    int noPersons,
    String ubication,
    boolean isReserved
) {
}
