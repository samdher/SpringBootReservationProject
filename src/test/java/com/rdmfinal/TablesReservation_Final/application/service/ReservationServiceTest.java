package com.rdmfinal.TablesReservation_Final.application.service;

import com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL.ReservationService;
import com.rdmfinal.TablesReservation_Final.application.service.PostGreSQL.TableBenchService;
import com.rdmfinal.TablesReservation_Final.domain.dto.ReservationDTO;
import com.rdmfinal.TablesReservation_Final.domain.dto.TableBenchDTO;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.Reservation;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.ReservationRepository;
import com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL.TableBenchRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReservationServiceTest {
    @Autowired
    private ReservationService reservationService;
    @MockBean
    private ReservationRepository reservationRepository;

    @Test
    void testCreateReservation() {
        // Given
        ReservationDTO reservationDTO = new ReservationDTO(
                null,
                1L,
                "Samuel Alvarado",
                new Date(),
                2,
                "Activa"
        );

        // When
        reservationService.createReserva(reservationDTO);

        // Then
        verify(reservationRepository).save(any(Reservation.class));
    }

    @Test
    @SneakyThrows
    void testReservationFindById() {
        // Given
        final long id = 1;
        // Retorna el service
        ReservationDTO reservationDTO = new ReservationDTO(
                1L,
                2L,
                "Samuel Alvarado",
                new Date(),
                2,
                "Activa"
        );
        // Retorno del repository
        Reservation expectedDto = Reservation.builder()
                .id(1L)
                .idTableBench(1L)
                .client("Samuel Alvarado")
                .dateReservation(new Date())
                .duration(2)
                .status("Activa")
                .build();

        // When
        when(reservationRepository.findById(id)).thenReturn(Optional.of(expectedDto));
        ReservationDTO resultDto = reservationService.findReservaById(id);

        // Then
        assertEquals(resultDto, resultDto);
    }

}
