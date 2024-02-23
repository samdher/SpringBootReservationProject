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
    @Autowired
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

    public void createMesa(TableBenchDTO tableBenchDTO){
        TableBench tableBench = TableBench.builder()
                .noPersons(tableBenchDTO.noPersons())
                .ubication(tableBenchDTO.ubication())
                .isReserved(tableBenchDTO.isReserved())
                .build();

        System.out.println("Se ha ingresado TableBench correctamente: "+ tableBench);
        // llamar a la interface del repository save
        tableBenchRepository.save(tableBench);
    }

    public TableBenchDTO findMesaById(Long id) throws DemoSecurityException {
        TableBench tableBench = tableBenchRepository.findById(id)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        return new TableBenchDTO(
                tableBench.getId(),
                tableBench.getNoPersons(),
                tableBench.getUbication(),
                tableBench.isReserved()
        );
    }

    public void deleteMesaByID(Long id) throws DemoSecurityException {
        TableBench tableBench = tableBenchRepository.findById(id)
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.DATA_NOT_FOUND)
                );
        tableBenchRepository.deleteById(id);
    }

}
