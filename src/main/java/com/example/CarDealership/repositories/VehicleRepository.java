package com.example.CarDealership.repositories;

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
                Vehicle v = mapRowToVehicle(rs);
                vehicles.add(v);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice){
        String query = "SELECT * FROM vehicles WHERE price >= ? AND price <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vehicle v = mapRowToVehicle(rs);
                    vehicles.add(v);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        String query = "SELECT * FROM vehicles WHERE LOWER(make) = ? AND LOWER(model) = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, make.toLowerCase());
            ps.setString(2, model.toLowerCase());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vehicle v = mapRowToVehicle(rs);
                    vehicles.add(v);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear){
        String query = "SELECT * FROM vehicles WHERE year >= ? AND year <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, minYear);
            ps.setDouble(2, maxYear);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vehicle v = mapRowToVehicle(rs);
                    vehicles.add(v);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        String query = "SELECT * FROM vehicles WHERE LOWER(color) = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, color.toLowerCase());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vehicle v = mapRowToVehicle(rs);
                    vehicles.add(v);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int minMiles, int maxMiles){
        String query = "SELECT * FROM vehicles WHERE mileage >= ? AND mileage <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, minMiles);
            ps.setDouble(2, maxMiles);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vehicle v = mapRowToVehicle(rs);
                    vehicles.add(v);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String type){
        String query = "SELECT * FROM vehicles WHERE LOWER(type) = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, type.toLowerCase());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vehicle v = mapRowToVehicle(rs);
                    vehicles.add(v);
                }
            }
        }
        catch (SQLException ex) {
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
