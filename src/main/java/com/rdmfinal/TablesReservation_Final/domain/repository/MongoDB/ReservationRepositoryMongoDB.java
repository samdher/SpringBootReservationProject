package com.rdmfinal.TablesReservation_Final.domain.repository.MongoDB;

import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.ReservationMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ReservationRepositoryMongoDB extends MongoRepository<ReservationMongoDB, String> {
}
