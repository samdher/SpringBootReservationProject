package com.rdmfinal.TablesReservation_Final.domain.repository.PostGreSQL;

import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByEmail(String email);

}
