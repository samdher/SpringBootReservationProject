package com.rdmfinal.TablesReservation_Final.application.service.MongoDB;

import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.lasting.EMessage;
import com.rdmfinal.TablesReservation_Final.application.service.GenericService;
import com.rdmfinal.TablesReservation_Final.domain.dto.ReservationDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.ReservationMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.TableBenchMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.Reservation;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.MongoDB.ReservationRepositoryMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.repository.MongoDB.TableBenchRepositoryMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.TableBenchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class ReservationServiceMongoDB implements GenericService <ReservationMongoDB, String>{
    private final ReservationRepositoryMongoDB reservationRepositoryMongoDB;

    public ReservationServiceMongoDB(ReservationRepositoryMongoDB reservationRepositoryMongo) {
        this.reservationRepositoryMongoDB = reservationRepositoryMongo;
    }

    public ReservationMongoDB save(ReservationMongoDB entity) {
        return (ReservationMongoDB)this.reservationRepositoryMongoDB.save(entity);
    }

    public Optional<ReservationMongoDB> findById(String id) {
        return this.reservationRepositoryMongoDB.findById(id);
    }

    public List<ReservationMongoDB> findAll() {
        return this.reservationRepositoryMongoDB.findAll();
    }

    public void deleteById(String id) {
        this.reservationRepositoryMongoDB.deleteById(id);
    }

    public void delete(ReservationMongoDB entity) {
        this.reservationRepositoryMongoDB.delete(entity);
    }
}
