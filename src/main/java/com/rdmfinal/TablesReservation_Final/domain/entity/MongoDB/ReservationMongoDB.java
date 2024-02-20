package com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
@ToString
public class ReservationMongoDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Long idMesa;
    private String cliente;
    private Date fechaReserva;
    private int duracion;
    private String estado;

}
