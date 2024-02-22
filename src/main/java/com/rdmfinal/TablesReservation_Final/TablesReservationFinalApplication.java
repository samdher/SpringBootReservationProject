package com.rdmfinal.TablesReservation_Final;

import com.rdmfinal.TablesReservation_Final.application.service.GenericService;
import com.rdmfinal.TablesReservation_Final.application.service.MongoDB.TableBenchServiceMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.entity.MongoDB.TableBenchMongoDB;
import com.rdmfinal.TablesReservation_Final.domain.entity.PostGreSQL.TableBench;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class TablesReservationFinalApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(TablesReservationFinalApplication.class, args);
	}
}
