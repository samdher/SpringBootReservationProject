package com.rdmfinal.TablesReservation_Final.domain.repository.MongoDB;

import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableBenchRepository extends JpaRepository<TableBench, Long> {

}
