package com.rdmfinal.TablesReservation_Final.application.service;

import com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL.TableBenchService;
import com.rdmfinal.TablesReservation_Final.domain.dto.TableBenchDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.TableBenchRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TableBenchServiceTest {
    @Autowired
    private TableBenchService tableBenchService;
    @MockBean
    private TableBenchRepository tableBenchRepository;

    @Test
    void testCreateTableBench() {
        // Given
        TableBenchDTO tableBenchDTO = new TableBenchDTO(
                null,
                2,
                "Jardin",
                false
        );

        // When
        tableBenchService.createMesa(tableBenchDTO);

        // Then
        verify(tableBenchRepository).save(any(TableBench.class));
    }

   @Test
    @SneakyThrows
    void testTableBenchFindById() {
        // Given
        final long id = 1;
        // Retorna el service
        TableBenchDTO tableBenchDTO = new TableBenchDTO(
                1L,
                2,
                "Jardin",
                true
        );
        // Retorno del repository
        TableBench expectedDto = TableBench.builder()
                .id(1L)
                .noPersons(2)
                .ubication("Jardin")
                .isReserved(false)
                .build();

        // When
        when(tableBenchRepository.findById(id)).thenReturn(Optional.of(expectedDto));
        TableBenchDTO resultDto = tableBenchService.findMesaById(id);

        // Then
        assertEquals(tableBenchDTO, resultDto);
    }
}
