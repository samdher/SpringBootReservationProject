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
    public ResponseEntity<?> registerReserva(@RequestBody ReservationDTO reservationDTO){
        reservationService.createReserva(reservationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findReservaById(@PathVariable Long id) throws DemoSecurityException {
        ReservationDTO reservationDTO = reservationService.findReservaById(id);
        return new ResponseEntity<>(reservationDTO, HttpStatus.FOUND);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteReservaByID(@PathVariable Long id) throws DemoSecurityException {
        reservationService.deleteReservaByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
