package com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL;

import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.lasting.EMessage;
import com.rdmfinal.TablesReservation_Final.application.service.GenericService;
import com.rdmfinal.TablesReservation_Final.domain.dto.TableBenchDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.Reservation;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.ReservationRepository;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.TableBenchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableBenchService implements GenericService<TableBench, Long> {
    private final TableBenchRepository tableBenchRepository;

    public TableBenchService(@Autowired TableBenchRepository tableBenchRepository) {
        this.tableBenchRepository = tableBenchRepository;
    }

    public TableBench save(TableBench entity) {
        return (TableBench)this.tableBenchRepository.save(entity);
    }

    public Optional<TableBench> findById(Long id) {
        return this.tableBenchRepository.findById(id);
    }

    public List<TableBench> findAll() {
        return this.tableBenchRepository.findAll();
    }

    public void deleteById(Long id) {
        this.tableBenchRepository.deleteById(id);
    }

    public void delete(TableBench entity) {
        this.tableBenchRepository.delete(entity);
    }

}
