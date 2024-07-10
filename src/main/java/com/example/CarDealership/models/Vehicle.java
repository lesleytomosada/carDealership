package com.example.CarDealership.models;

public class Vehicle {
    private int vehicleId;
    private String vin;
    private int year;
    private String make;
    private String model;
    private String color;
    private int mileage;
    private double price;
    private boolean sold;

    public Vehicle(int vehicleId, String vin, int year, String make, String model, String color, int mileage,
            double price,
            boolean sold) {
        this.vehicleId = vehicleId;
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.sold = sold;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicle(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        // Define column widths
        int idWidth = 10;
        int vinWidth = 20;
        int yearWidth = 6;
        int makeWidth = 15;
        int modelWidth = 15;
        int colorWidth = 10;
        int mileageWidth = 10;
        int priceWidth = 10;
        int soldWidth = 5;

        // Format string for each row
        return String.format("%-" + idWidth + "d %-" + vinWidth + "s %-" + yearWidth + "d %-" + makeWidth + "s %-" + modelWidth + "s %-" + colorWidth + "s %-" + mileageWidth + "d %-" + priceWidth + ".2f %-" + soldWidth + "b",
                vehicleId, vin, year, make, model, color, mileage, price, sold);
    }
}
