package com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL;

import com.rdmfinal.TablesReservation_Final.application.exception.DemoSecurityException;
import com.rdmfinal.TablesReservation_Final.application.lasting.EMessage;
import com.rdmfinal.TablesReservation_Final.domain.dto.TableBenchDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.TableBenchRepository;
import org.springframework.stereotype.Service;

@Service
public record TableBenchService(TableBenchRepository tableBenchRepository) {
    public void createMesa(TableBenchDTO tableBenchDTO){
        TableBench tableBench = TableBench.builder()
                .noPersonas(tableBenchDTO.noPersonas())
                .ubicacion(tableBenchDTO.ubicacion())
                .reservada(tableBenchDTO.reservada())
                .build();

        System.out.println("Se ha ingresado TableBench correctamente: "+ tableBench);
        // llamar a la interface del repository save
        tableBenchRepository.save(tableBench);
    }

    public TableBenchDTO findMesaById(Long idMesa) throws DemoSecurityException {
        TableBench tableBench = tableBenchRepository.findById(idMesa)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        return new TableBenchDTO(
                tableBench.getIdMesa(),
                tableBench.getNoPersonas(),
                tableBench.getUbicacion(),
                tableBench.isReservada()
        );
    }

    public void deleteMesaByID(Long idMesa) throws DemoSecurityException {
        TableBench tableBench = tableBenchRepository.findById(idMesa)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        tableBenchRepository.deleteById(idMesa);
    }
}
