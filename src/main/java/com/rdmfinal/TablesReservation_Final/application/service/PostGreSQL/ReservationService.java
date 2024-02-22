package com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL;

import com.rdmfinal.TablesReservation_Final.application.service.GenericService;
import com.rdmfinal.TablesReservation_Final.domain.dto.ReservationDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.ReservationMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.Reservation;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.TableBenchRepository;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.lasting.EMessage;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements GenericService<Reservation, Long> {
    private final ReservationRepository reservationRepository;

    public ReservationService(@Autowired ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation save(Reservation entity) {
        return (Reservation)this.reservationRepository.save(entity);
    }

    public Optional<Reservation> findById(Long id) {
        return this.reservationRepository.findById(id);
    }

    public List<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }

    public void deleteById(Long id) {
        this.reservationRepository.deleteById(id);
    }

    public void delete(Reservation entity) {
        this.reservationRepository.delete(entity);
    }


}
