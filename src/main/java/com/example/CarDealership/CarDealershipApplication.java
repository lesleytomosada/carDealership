package com.example.CarDealership;

import com.example.CarDealership.config.DataSourceProperties;
import com.example.CarDealership.models.Dealership;
import com.example.CarDealership.repositories.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.util.List;

@SpringBootApplication
public class CarDealershipApplication implements CommandLineRunner {

	@Autowired
	private DealershipRepository dealershipRepository;

	@Autowired
	private DataSourceProperties dataSourceProperties;


	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		List<Dealership> dealershipList = dealershipRepository.getAllDealerships();
		dealershipList.forEach(System.out::println);
	}

}
