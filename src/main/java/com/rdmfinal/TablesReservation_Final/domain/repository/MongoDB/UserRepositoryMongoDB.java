package com.rdmfinal.TablesReservation_Final.domain.repository.MongoDB;

import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.UserMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepositoryMongoDB extends MongoRepository<UserMongoDB, String> {

  Optional<UserMongoDB> findUserByEmail(String email);

}
