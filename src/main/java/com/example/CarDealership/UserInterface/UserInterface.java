package com.example.CarDealership.UserInterface;

import com.example.CarDealership.models.Vehicle;
import com.example.CarDealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserInterface {
    @Autowired
    VehicleRepository vehicleRepository;

    Scanner scanner = new Scanner(System.in);

    public void displayMenu(){
        int response;
        do {
            System.out.print("""
                    Please choose an option:
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - List ALL vehicles
                    7 - Add a vehicle
                    8 - Remove a vehicle
  
                    99 - Quit
                    """);
            response = scanner.nextInt();
            scanner.nextLine();
            if (response < 1 || response > 9) {
                response = 99;
            } else {
                handleResponse(response);
            }
        } while (response != 99);
    }

    private void handleResponse(int response) {
        switch(response){
            case 1 -> processGetByPriceRequest();
            case 2 -> processGetByMakeModelRequest();
            case 3 -> processGetByYearRequest();
            case 4 -> processGetByColorRequest();
            case 5 -> processGetByMileageRequest();
            case 6 -> processGetAllVehiclesRequest();
            case 7 -> processAddVehicleRequest();
            case 8 -> processRemoveVehicleRequest();
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles != null && !vehicles.isEmpty()) {
            // Define column widths. Adjust these values based on your data for better alignment.
            int vinWidth = 10;
            int yearWidth = 6;
            int makeWidth = 10;
            int modelWidth = 10;
            int colorWidth = 10;
            int odometerWidth = 10;
            int priceWidth = 10;

            // Print header
            System.out.printf("%-" + vinWidth + "s %-" + yearWidth + "s %-" + makeWidth + "s %-" + modelWidth + "s %-" +
                            colorWidth + "s %-" + odometerWidth + "s %-" + priceWidth + "s\n", "VIN",
                    "Year", "Make", "Model", "Color", "Odometer", "Price");

            // Print each vehicle's details
            for (Vehicle vehicle : vehicles) {
                System.out.printf(
                        "%-" + vinWidth + "s %-" + yearWidth + "d %-" + makeWidth + "s %-" + modelWidth + "s %-" +
                                colorWidth + "s %-" + odometerWidth + "d $%-" + (priceWidth - 1) +
                                ".2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getColor(),
                        vehicle.getMileage(),
                        vehicle.getPrice());
            }
            System.out.println();
        } else {
            System.out.println("No vehicles found matching those search terms");
        }
    }

    void processGetByPriceRequest() {
        double minPrice;
        double maxPrice;

        do {
            System.out.print("Min Price: ");
            minPrice = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Max Price: ");
            maxPrice = scanner.nextDouble();
            scanner.nextLine();

            if (maxPrice < minPrice) {
                System.out.println("Please enter a max year after the min year");
            }
        } while (maxPrice < minPrice);

        List<Vehicle> priceFiltered = vehicleRepository.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(priceFiltered);
    }

    void processGetByMakeModelRequest() {
        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        List<Vehicle> makeModelFiltered = vehicleRepository.getVehiclesByMakeModel(make, model);
        displayVehicles(makeModelFiltered);
    }

    void processGetByYearRequest() {
        int min;
        int max;
        do {
            System.out.print("Min Year: ");
            min = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Max Year: ");
            max = scanner.nextInt();
            scanner.nextLine();
            if (max < min) {
                System.out.println("Please enter a max year after the min year");
            }
        } while (max < min);

        List<Vehicle> yearFiltered = vehicleRepository.getVehiclesByYear(min, max);
        displayVehicles(yearFiltered);
    }

    void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine();

        List<Vehicle> colorFiltered = vehicleRepository.getVehiclesByColor(color);
        displayVehicles(colorFiltered);
    }

    void processGetByMileageRequest() {
        int min;
        int max;
        do {
            System.out.print("Min Mileage: ");
            min = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Max Mileage: ");
            max = scanner.nextInt();
            scanner.nextLine();
            if (max < min) {
                System.out.println("Please enter a max mileage below the min mileage");
            }
        } while (max < min);

        List<Vehicle> mileageFiltered = vehicleRepository.getVehiclesByMileage(min, max);
        displayVehicles(mileageFiltered);
    }


    void processGetAllVehiclesRequest() {
        displayVehicles(vehicleRepository.getAllVehicles());

    }

    void processAddVehicleRequest() {
        System.out.print("What is the vin of the car? ");
        String vin = scanner.nextLine();
        System.out.print("What is the year of the car? ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What is the make of the car? ");
        String make = scanner.nextLine();
        System.out.print("What is the model of the car? ");
        String model = scanner.nextLine();
        System.out.print("What is the color of the car? ");
        String color = scanner.nextLine();
        System.out.print("What is the mileage of the car? ");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What is the price of the car? ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Has the car been sold? (Y/N) ");
        String soldString = scanner.nextLine();
        boolean sold = soldString.equalsIgnoreCase("y");
        Vehicle vehicle = new Vehicle(0, vin, year, make, model, color, mileage, price, sold);
        vehicleRepository.createVehicle(vehicle);
        System.out.println("Vehicle added.");
    }

    void processRemoveVehicleRequest() {

    }


}
