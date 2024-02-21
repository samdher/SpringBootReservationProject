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
	public TablesReservationFinalApplication(){

	}

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(TablesReservationFinalApplication.class, args);

		GenericService genericService = (GenericService)applicationContext.getBean(GenericService.class);
		List all;
		Iterator var4;
		if (genericService instanceof TableBenchServiceMongoDB) {
			genericService.save(new TableBenchMongoDB(5,"Jardin",false));
			all = genericService.findAll();
			var4 = all.iterator();

			while(var4.hasNext()) {
				TableBenchMongoDB tableBenchMongoDB = (TableBenchMongoDB)var4.next();
				System.out.println(tableBenchMongoDB);
			}
		} else {
			genericService.save(new TableBench(10,"azotea",false));
			all = genericService.findAll();
			var4 = all.iterator();

			while(var4.hasNext()) {
				TableBench tableBench = (TableBench)var4.next();
				System.out.println(tableBench);
			}
		}
	}
}
