package com.rdmfinal.ReservacionDeMesas_Final.application.controller;

import com.rdmfinal.ReservacionDeMesas_Final.application.exception.DemoSecurityException;
import com.rdmfinal.ReservacionDeMesas_Final.application.service.MesaService;
import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.MesaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mesa")
public record MesaController(MesaService mesaService) {
    @PostMapping
    public ResponseEntity<?> registerMesa(@RequestBody MesaDTO mesaDTO){
        mesaService.createMesa(mesaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{idMesa}")
    public ResponseEntity<?> findMesaById(@PathVariable Long idMesa) throws DemoSecurityException {
        MesaDTO mesaDTO = mesaService.findMesaById(idMesa);
        return new ResponseEntity<>(mesaDTO, HttpStatus.FOUND);
    }

    @PostMapping("/{idMesa}")
    public ResponseEntity<?> deleteMesaByID(@PathVariable Long idMesa) throws DemoSecurityException {
        mesaService.deleteMesaByID(idMesa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
