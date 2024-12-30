package app.src.main.java.oop.java.tori.customer;

import java.util.List;

import app.src.main.java.oop.java.tori.rating.Entity;
import app.src.main.java.oop.java.tori.rental.RentalTransaction;
import app.src.main.java.oop.java.tori.vehicle.Vehicle;

public class Customer extends Entity {
    static final int Max_Number_Of_Vehicles = 3;

    private String customerId;
    private String customerName;
    private boolean hasCarLicense;
    private boolean hasMotorcycleLicense;
    private boolean hasTruckLicense;
    private List<Vehicle> rentedVehicles;
    private List<RentalTransaction> rentalTransactions;

    public Customer(String customerId, String customerName, boolean hasCarLicense, boolean hasMotorcycleLicense,
            boolean hasTruckLicense, List<Vehicle> rentedVehicles, List<RentalTransaction> rentalTransactions) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.hasCarLicense = hasCarLicense;
        this.hasMotorcycleLicense = hasMotorcycleLicense;
        this.hasTruckLicense = hasTruckLicense;
        this.rentedVehicles = rentedVehicles;
        this.rentalTransactions = rentalTransactions;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public boolean isCustomerEligibleToRent() {
        return this.rentedVehicles.size() < Max_Number_Of_Vehicles;
    }

    public boolean getHasCarLicense() {
        return this.hasCarLicense;
    }

    public boolean getHasMotorcycleLicense() {
        return this.hasMotorcycleLicense;
    }

    public boolean getHasTruckLicense() {
        return this.hasTruckLicense;
    }

    public List<Vehicle> getRentals() {
        return this.rentedVehicles;
    }

    public List<RentalTransaction> getRentalTransactions() {
        return this.rentalTransactions;
    }

    public void addRental(Vehicle vehicle) {
        this.rentedVehicles.add(vehicle);
    }

    public void removeRental(Vehicle vehicle) {
        this.rentedVehicles.remove(vehicle);
    }

    public void addRentalTransaction(Customer customer, Vehicle vehicle, int days) {
        this.rentalTransactions
                .add(new RentalTransaction(customer.getCustomerId(), vehicle, days));
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", hasCarLicense=" + hasCarLicense +
                ", hasMotorcycleLicense=" + hasMotorcycleLicense +
                ", hasTruckLicense=" + hasTruckLicense +
                ", rentedVehicles=" + rentedVehicles +
                ", rentalTransactions=" + rentalTransactions +
                '}';
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setHasCarLicense(boolean hasCarLicense) {
        this.hasCarLicense = hasCarLicense;
    }

    public void setHasMotorcycleLicense(boolean hasMotorcycleLicense) {
        this.hasMotorcycleLicense = hasMotorcycleLicense;
    }

    public void setHasTruckLicense(boolean hasTruckLicense) {
        this.hasTruckLicense = hasTruckLicense;
    }

    public void setRentedVehicles(List<Vehicle> rentedVehicles) {
        this.rentedVehicles = rentedVehicles;
    }

    public void setRentalTransactions(List<RentalTransaction> rentalTransactions) {
        this.rentalTransactions = rentalTransactions;
    }
}
