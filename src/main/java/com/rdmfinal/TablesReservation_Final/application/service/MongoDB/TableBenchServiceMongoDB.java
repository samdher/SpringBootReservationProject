package com.rdmfinal.TablesReservation_Final.application.service.MongoDB;

import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.lasting.EMessage;
import com.rdmfinal.TablesReservation_Final.application.service.GenericService;
import com.rdmfinal.TablesReservation_Final.domain.dto.TableBenchDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.ReservationMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.TableBenchMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.MongoDB.ReservationRepositoryMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.repository.MongoDB.TableBenchRepositoryMongoDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class TableBenchServiceMongoDB implements GenericService<TableBenchMongoDB, String> {
    private final TableBenchRepositoryMongoDB tableBenchRepositoryMongoDB;

    public TableBenchServiceMongoDB(TableBenchRepositoryMongoDB tableBenchRepositoryMongoDB) {
        this.tableBenchRepositoryMongoDB = tableBenchRepositoryMongoDB;
    }

    public TableBenchMongoDB save(TableBenchMongoDB entity) {
        return (TableBenchMongoDB)this.tableBenchRepositoryMongoDB.save(entity);
    }

    public Optional<TableBenchMongoDB> findById(String id) {
        return this.tableBenchRepositoryMongoDB.findById(id);
    }

    public List<TableBenchMongoDB> findAll() {
        return this.tableBenchRepositoryMongoDB.findAll();
    }

    public void deleteById(String id) {
        this.tableBenchRepositoryMongoDB.deleteById(id);
    }

    public void delete(TableBenchMongoDB entity) {
        this.tableBenchRepositoryMongoDB.delete(entity);
    }
}

