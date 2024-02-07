package com.rdmfinal.ReservacionDeMesas_Final.application.service;

import com.rdmfinal.ReservacionDeMesas_Final.application.exception.DemoSecurityException;
import com.rdmfinal.ReservacionDeMesas_Final.application.lasting.EMessage;
import com.rdmfinal.ReservacionDeMesas_Final.domain.dto.MesaDTO;
import com.rdmfinal.ReservacionDeMesas_Final.domain.entity.Mesa;
import com.rdmfinal.ReservacionDeMesas_Final.domain.repository.MesaRepository;
import org.springframework.stereotype.Service;

@Service
public record MesaService(MesaRepository mesaRepository) {
    public void createMesa(MesaDTO mesaDTO){
        Mesa mesa = Mesa.builder()
                .noPersonas(mesaDTO.noPersonas())
                .ubicacion(mesaDTO.ubicacion())
                .reservada(mesaDTO.reservada())
                .build();

        System.out.println("Se ha ingresado Mesa correctamente: "+ mesa);
        // llamar a la interface del repository save
        mesaRepository.save(mesa);
    }

    public MesaDTO findMesaById(Long idMesa) throws DemoSecurityException {
        Mesa mesa = mesaRepository.findById(idMesa)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        return new MesaDTO(
                mesa.getIdMesa(),
                mesa.getNoPersonas(),
                mesa.getUbicacion(),
                mesa.isReservada()
        );
    }

    public void deleteMesaByID(Long idMesa) throws DemoSecurityException {
        Mesa mesa = mesaRepository.findById(idMesa)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        mesaRepository.deleteById(idMesa);
    }
}
