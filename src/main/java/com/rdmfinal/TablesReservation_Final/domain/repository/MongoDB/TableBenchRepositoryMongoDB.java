package com.rdmfinal.TablesReservation_Final.domain.repository.MongoDB;

import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.TableBenchMongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TableBenchRepositoryMongoDB extends MongoRepository<TableBenchMongoDB, String> {

}
