package com.rdmfinal.ReservacionDeMesas_Final.domain.repository;

import com.rdmfinal.ReservacionDeMesas_Final.domain.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
