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
    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private final TableBenchRepository tableBenchRepository;

    public ReservationService(@Autowired ReservationRepository reservationRepository, @Autowired TableBenchRepository tableBenchRepository) {
        this.reservationRepository = reservationRepository;
        this.tableBenchRepository = tableBenchRepository;
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

    public void createReserva(ReservationDTO reservationDTO){
        try {
            TableBench tableBench = tableBenchRepository.findById(reservationDTO.idTableBench())
                    .orElseThrow(
                            () -> new DemoSecurityException(EMessage.MESA_NOT_FOUND)
                    );

            if (!tableBench.isReserved()) //Disponible
            {
                Reservation reservation = Reservation.builder()
                        .idTableBench(reservationDTO.idTableBench())
                        .client(reservationDTO.client())
                        .dateReservation(reservationDTO.dateReservation())
                        .duration(reservationDTO.duration())
                        .status(reservationDTO.status())
                        .build();

                System.out.println("Guardando reservation "+ reservation);

                // llamar a la interface del repository save
                reservationRepository.save(reservation);

            }
            else {
                System.out.println("TableBench no disponible. ");
                throw new  DemoSecurityException(EMessage.MESA_NOT_AVAILABLE);
            }
        } catch (DemoSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public ReservationDTO findReservaById(Long id) throws DemoSecurityException {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        return new ReservationDTO(
                reservation.getId(),
                reservation.getIdTableBench(),
                reservation.getClient(),
                reservation.getDateReservation(),
                reservation.getDuration(),
                reservation.getStatus()
        );
    }

    public void deleteReservaByID(Long id) throws DemoSecurityException {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        reservationRepository.deleteById(id);
    }

}
