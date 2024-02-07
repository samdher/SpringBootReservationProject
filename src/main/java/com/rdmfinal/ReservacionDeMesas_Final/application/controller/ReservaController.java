package com.rdmfinal.ReservacionDeMesas_Final.application.controller;

import com.rdmfinal.ReservacionDeMesas_Final.application.exception.DemoSecurityException;
import com.rdmfinal.ReservacionDeMesas_Final.application.service.ReservaService;
import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.MesaDTO;
import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.ReservaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservar")
public record ReservaController(ReservaService reservaService) {
    @PostMapping
    public ResponseEntity<?> registerReserva(@RequestBody ReservaDTO reservaDTO){
        reservaService.createReserva(reservaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findReservaById(@PathVariable Long id) throws DemoSecurityException {
        ReservaDTO reservaDTO = reservaService.findReservaById(id);
        return new ResponseEntity<>(reservaDTO, HttpStatus.FOUND);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteReservaByID(@PathVariable Long id) throws DemoSecurityException {
        reservaService.deleteReservaByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
