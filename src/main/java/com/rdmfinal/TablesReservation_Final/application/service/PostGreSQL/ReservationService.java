package com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL;

import com.rdmfinal.TablesReservation_Final.domain.dto.ReservationDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.Reservation;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.TableBenchRepository;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.ReservationRepository;
import org.springframework.stereotype.Service;
import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.lasting.EMessage;

@Service
public record ReservationService(
        ReservationRepository reservationRepository,
        TableBenchRepository tableBenchRepository
) {
    public void createReserva(ReservationDTO reservationDTO){
        try {
            TableBench tableBench = tableBenchRepository.findById(reservationDTO.idMesa())
                    .orElseThrow(
                            () -> new DemoSecurityException(EMessage.MESA_NOT_FOUND)
                    );

            if (!tableBench.isReservada()) //Disponible
            {
                Reservation reservation = Reservation.builder()
                        .idMesa(reservationDTO.idMesa())
                        .cliente(reservationDTO.cliente())
                        .fechaReserva(reservationDTO.fechaReserva())
                        .duracion(reservationDTO.duracion())
                        .estado(reservationDTO.estado())
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
                reservation.getIdMesa(),
                reservation.getCliente(),
                reservation.getFechaReserva(),
                reservation.getDuracion(),
                reservation.getEstado()
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
