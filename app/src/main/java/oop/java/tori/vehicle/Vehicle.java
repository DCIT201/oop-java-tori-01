package app.src.main.java.oop.java.tori.vehicle;

import java.util.Objects;

import app.src.main.java.oop.java.tori.interfaces.Rentable;
import app.src.main.java.oop.java.tori.rating.Entity;

public abstract class Vehicle extends Entity implements Rentable {
    public abstract double calculateRentalCost(int days);

    public abstract boolean isAvailableForRental();

    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setVehicleId(String vehicleId) {
        if (vehicleId.isEmpty()) {
            System.out.println("vehicleId must not be empty");
        } else {
            this.vehicleId = vehicleId;
        }

    }

    public void setModel(String model) {
        if (model.isEmpty()) {
            System.out.println("model must not be empty");
        } else {
            this.model = model;
        }

    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate == 0) {
            System.out.println("baseRentalRate must not be equal to 0");
        } else {
            this.baseRentalRate = baseRentalRate;
        }

    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Vehicle vehicle = (Vehicle) obj;

        return Objects.equals(vehicleId, vehicle.vehicleId) &&
                Objects.equals(model, vehicle.model) &&
                Double.compare(baseRentalRate, vehicle.baseRentalRate) == 0 &&
                isAvailable == vehicle.isAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}