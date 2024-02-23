package com.rdmfinal.TablesReservation_Final.application.service;

import com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL.TableBenchService;
import com.rdmfinal.TablesReservation_Final.domain.dto.TableBenchDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.TableBenchRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

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

}
