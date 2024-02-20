package com.rdmfinal.TablesReservation_Final.application.controller;

import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL.TableBenchService;
import com.rdmfinal.TablesReservation_Final.domain.dto.TableBenchDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tablebench")
public record TableBenchController(TableBenchService tableBenchService) {
    @PostMapping
    public ResponseEntity<?> registerMesa(@RequestBody TableBenchDTO tableBenchDTO){
        tableBenchService.createMesa(tableBenchDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{idtablebench}")
    public ResponseEntity<?> findMesaById(@PathVariable Long idTableBench) throws DemoSecurityException {
        TableBenchDTO tableBenchDTO = tableBenchService.findMesaById(idTableBench);
        return new ResponseEntity<>(tableBenchDTO, HttpStatus.FOUND);
    }

    @PostMapping("/{idtablebench}")
    public ResponseEntity<?> deleteMesaByID(@PathVariable Long idTableBench) throws DemoSecurityException {
        tableBenchService.deleteMesaByID(idTableBench);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
