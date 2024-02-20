package com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL;

import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
