package com.rdmfinal.TablesReservation_Final.application.controller;

import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL.ReservationService;
import com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL.TableBenchService;
import com.rdmfinal.TablesReservation_Final.domain.dto.TableBenchDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.Reservation;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tablebench")
public class TableBenchController {
    private final TableBenchService tableBenchService;

    public TableBenchController(@Autowired TableBenchService tableBenchService) {

        this.tableBenchService = tableBenchService;
    }

   @PostMapping
    public ResponseEntity<?> registerMesa(@RequestBody TableBenchDTO tableBenchDTO){
        tableBenchService.createMesa(tableBenchDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findMesaById(@PathVariable Long id) throws DemoSecurityException {
        TableBenchDTO tableBenchDTO = tableBenchService.findMesaById(id);
        return new ResponseEntity<>(tableBenchDTO, HttpStatus.FOUND);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteMesaByID(@PathVariable Long id) throws DemoSecurityException {
        tableBenchService.deleteMesaByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
