package com.example.CarDealership.models;

import java.time.LocalDate;

public class SalesContract {
    private int saleId;
    private int vehicleId;
    private int customerId;
    private int salePrice;
    private LocalDate sale_date;

    public SalesContract(int saleId, int vehicleId, int customerId, int salePrice, LocalDate sale_date) {
        this.saleId = saleId;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.salePrice = salePrice;
        this.sale_date = sale_date;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public LocalDate getSale_date() {
        return sale_date;
    }

    public void setSale_date(LocalDate sale_date) {
        this.sale_date = sale_date;
    }
}
