/*
Esta clase sive para poder realizar mantenimiento a nuestras reservas según la mesa que se necesite gestionar.
Dentro de las operaciones que se pueden realizar están la de:
    - Crear una reserva, cabe mencionar que si la mesa está ocupada no deja asignar reservación
    - Consultar una reserva
    - Eliminar una reserva

Para los cuales se ejecutan instrucciones según sea el caso de método get para traer datos,
y post para mandar datos a la BD
*/

package com.rdmfinal.TablesReservation_Final.application.controller;

import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL.ReservationService;
import com.rdmfinal.TablesReservation_Final.domain.dto.ReservationDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(@Autowired ReservationService reservationService) {

        this.reservationService = reservationService;
    }

    @RequestMapping({"/{id}"})
    public ResponseEntity<Reservation> findUserById(@PathVariable Long id) {
        Optional<Reservation> reservation = this.reservationService.findById(id);
        return reservation.isPresent() ? ResponseEntity.ok((Reservation)reservation.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> registerReserva(@RequestBody ReservationDTO reservationDTO)
    { // Para realizar una reserva
        reservationService.createReserva(reservationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}") //Para encontrar una reserva
    public ResponseEntity<?> findReservaById(@PathVariable Long id) throws DemoSecurityException {
        ReservationDTO reservationDTO = reservationService.findReservaById(id);
        return new ResponseEntity<>(reservationDTO, HttpStatus.FOUND);
    }

    @PostMapping("/{id}") //Para eliminar Rerservas
    public ResponseEntity<?> deleteReservaByID(@PathVariable Long id) throws DemoSecurityException {
        reservationService.deleteReservaByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
