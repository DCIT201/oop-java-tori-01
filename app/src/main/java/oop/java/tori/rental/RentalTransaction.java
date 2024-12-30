package app.src.main.java.oop.java.tori.rental;

import app.src.main.java.oop.java.tori.vehicle.Vehicle;

public class RentalTransaction {
    private String customerId;
    private Vehicle vehicle;
    private int numberOfDays;

    public RentalTransaction(
            String customerId,
            Vehicle vehicle,
            int numberOfDays

    ) {
        this.customerId = customerId;
        this.vehicle = vehicle;
        this.numberOfDays = numberOfDays;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setCustomerId(String customerId) {
        if (customerId.isEmpty()) {
            System.out.println("CustomerId cannot be empty");
            return;
        }
        this.customerId = customerId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setNumberOfDays(int numberOfDays) {
        if (numberOfDays <= 0) {
            System.out.println("Number of days cannot be 0 or negative");
            return;
        }
        this.numberOfDays = numberOfDays;
    }
}
