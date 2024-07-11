package com.example.CarDealership;

import com.example.CarDealership.config.DataSourceProperties;
import com.example.CarDealership.models.Dealership;
import com.example.CarDealership.models.Vehicle;
import com.example.CarDealership.repositories.DealershipRepository;
import com.example.CarDealership.repositories.VehicleRepository;
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
    private VehicleRepository vehicleRepository;


	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
//		List<Dealership> dealershipList = dealershipRepository.getAllDealerships();
//		dealershipList.forEach(System.out::println);
//		List<Vehicle> vehicleList = vehicleRepository.getAllVehicles();
//		vehicleList.forEach(System.out::println);
//		List<Vehicle> vehiclesByPrice = vehicleRepository.getVehiclesByPrice(1,100000);
//		vehiclesByPrice.forEach(System.out::println);
//		List<Vehicle> vehiclesByMakeModel= vehicleRepository.getVehiclesByMakeModel("bmw","m2");
//		vehiclesByMakeModel.forEach(System.out::println);
//		List<Vehicle> vehiclesByYear= vehicleRepository.getVehiclesByYear(1990, 2025);
//		vehiclesByYear.forEach(System.out::println);
//		List<Vehicle> vehiclesByColor = vehicleRepository.getVehiclesByColor("white");
//		vehiclesByColor.forEach(System.out::println);
//		List<Vehicle> vehiclesByMileage = vehicleRepository.getVehiclesByMileage(100, 10000);
//		vehiclesByMileage.forEach(System.out::println);
		List<Vehicle> vehiclesByType = vehicleRepository.getVehiclesByType("SUV");
		vehiclesByType.forEach(System.out::println);

	}

}
