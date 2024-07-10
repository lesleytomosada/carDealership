package com.example.CarDealership.repositories;

import com.example.CarDealership.models.Dealership;
import com.example.CarDealership.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    @Autowired
    private DataSource dataSource;

    //get all vehicles
    public List<Vehicle> getAllVehicles(){
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Vehicle d = mapRowToVehicle(rs);
                vehicles.add(d);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    private Vehicle mapRowToVehicle(ResultSet rs) throws SQLException {
        int vehicleId = rs.getInt("vehicle_id");
        String vin = rs.getString("vin");
        int year = rs.getInt("year");
        String make = rs.getString("make");
        String model = rs.getString("model");
        String color = rs.getString("color");
        int mileage = rs.getInt("mileage");
        double price = rs.getDouble("price");
        boolean sold = rs.getBoolean("sold");
        return new Vehicle(vehicleId, vin, year, make, model, color, mileage, price, sold);
    }

}
