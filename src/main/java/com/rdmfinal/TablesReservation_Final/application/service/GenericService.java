package com.rdmfinal.TablesReservation_Final.application.service;

import java.util.List;
import java.util.Optional;

public interface GenericService <T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    void delete(T entity);
}
