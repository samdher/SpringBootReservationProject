package com.rdmfinal.ReservacionDeMesas_Final.application.service;

import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.ReservaDTO;
import com.rdmfinal.ReservacionDeMesas_Final.domain.entity.Mesa;
import com.rdmfinal.ReservacionDeMesas_Final.domain.entity.Reserva;
import com.rdmfinal.ReservacionDeMesas_Final.domain.repository.MesaRepository;
import com.rdmfinal.ReservacionDeMesas_Final.domain.repository.ReservaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.rdmfinal.ReservacionDeMesas_Final.application.exception.DemoSecurityException;
import com.rdmfinal.ReservacionDeMesas_Final.application.lasting.EMessage;

@Service
public record ReservaService(
        ReservaRepository reservaRepository,
        MesaRepository mesaRepository
) {
    public void createReserva(ReservaDTO reservaDTO){
        try {
            Mesa mesa = mesaRepository.findById(reservaDTO.idMesa())
                    .orElseThrow(
                            () -> new DemoSecurityException(EMessage.MESA_NOT_FOUND)
                    );

            if (!mesa.isReservada()) //Disponible
            {
                Reserva reserva = Reserva.builder()
                        .idMesa(reservaDTO.idMesa())
                        .cliente(reservaDTO.cliente())
                        .fechaReserva(reservaDTO.fechaReserva())
                        .duracion(reservaDTO.duracion())
                        .estado(reservaDTO.estado())
                        .build();

                System.out.println("Guardando reserva "+reserva);

                // llamar a la interface del repository save
                reservaRepository.save(reserva);

            }
            else {
                System.out.println("Mesa no disponible. ");
                throw new  DemoSecurityException(EMessage.MESA_NOT_AVAILABLE);
            }
        } catch (DemoSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public ReservaDTO findReservaById(Long id) throws DemoSecurityException {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        return new ReservaDTO(
                reserva.getId(),
                reserva.getIdMesa(),
                reserva.getCliente(),
                reserva.getFechaReserva(),
                reserva.getDuracion(),
                reserva.getEstado()
        );
    }

    public void deleteReservaByID(Long id) throws DemoSecurityException {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        reservaRepository.deleteById(id);
    }

}
