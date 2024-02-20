package com.rdmfinal.TablesReservation_Final.application.controller;

import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.service.ReservationService;
import com.rdmfinal.TablesReservation_Final.domain.dto.ReservationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
public record ReservationController(ReservationService reservationService) {
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
