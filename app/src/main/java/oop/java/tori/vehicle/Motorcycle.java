package app.src.main.java.oop.java.tori.vehicle;

import app.src.main.java.oop.java.tori.customer.Customer;

public class Motorcycle extends Vehicle {
    static final int Extra_Days_Count = 30;
    static final int Charge_Per_Extra_Day = 5;
    static final int Max_Number_Of_Vehicles = 90;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public double calculateRentalCost(int days) {
        final double baseCost = days * getBaseRentalRate();
        final int extraDays = days / Extra_Days_Count;
        final double extraCharge = extraDays * Charge_Per_Extra_Day;

        return baseCost + extraCharge;
    }

    @Override
    public boolean isAvailableForRental() {
        return true;
    }

    @Override
    public void rent(Customer customer, int days) {
        if (days <= 0) {
            System.out.println("Number of days cannot be 0 or negative");
            return;
        }

        if (days > Max_Number_Of_Vehicles) {
            return;
        }

        if (!customer.isCustomerEligibleToRent()) {
            return;
        }

        if (!customer.getHasMotorcycleLicense()) {
            return;
        }

        if (!getIsAvailable()) {
            System.out.println("Motorcycle not available");
            return;
        }

        setIsAvailable(false);
        customer.addRental(this);
        customer.addRentalTransaction(customer, this, days);
        System.out.println("Motorcycle rented successfully!");
    }

    @Override
    public void returnVehicle() {
        setIsAvailable(true);
        System.out.println("Motorcycle returned");
    }

    @Override
    public void returnVehicle(Customer customer) {
        setIsAvailable(true);
        customer.removeRental(this);
        System.out.println("Motorcycle returned");
    }
}