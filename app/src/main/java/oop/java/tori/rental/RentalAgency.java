package app.src.main.java.oop.java.tori.rental;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import app.src.main.java.oop.java.tori.vehicle.Vehicle;

public class RentalAgency {
    private String id;
    private String name;
    private List<Vehicle> vehicles;

    public RentalAgency(String id, String name) {
        this.id = id;
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    public void setId(String id) {
        if (id.isEmpty()) {
            System.out.println("ID cannot be empty");
            return;
        }

        this.id = id;
    }

    public void setName(String name) {

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty");
            return;
        }

        this.name = name;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void addVehicle(List<Vehicle> vehicles) {
        this.vehicles.addAll(vehicles);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void remoteVehicle(List<Vehicle> vehicles) {
        this.vehicles.removeAll(vehicles);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Vehicle> getAllVehicles() {
        return this.vehicles;
    }

    public List<Vehicle> getAvailableVehicles() {
        return this.vehicles.stream().filter(vehicle -> vehicle.getIsAvailable()).toList();
    }

    public List<Vehicle> getUnvailableVehicles() {
        return this.vehicles.stream().filter(vehicle -> !vehicle.getIsAvailable()).toList();
    }

    public void generateReport() {
        System.out.println("Rental Agency Report");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Total Vehicles: " + vehicles.size());
        System.out.println("Available Vehicles: " + getAvailableVehicles().size());
        System.out.println("Unavailable Vehicles: " + getUnvailableVehicles().size());
        System.out.println("Vehicle Details:");
        vehicles.forEach(vehicle -> System.out.println(vehicle));
    }

    // Overriding toString method
    @Override
    public String toString() {
        String availableVehicles = vehicles.stream()
                .filter(Vehicle::getIsAvailable)
                .map(Vehicle::toString)
                .collect(Collectors.joining(", "));

        String unavailableVehicles = vehicles.stream()
                .filter(vehicle -> !vehicle.getIsAvailable())
                .map(Vehicle::toString)
                .collect(Collectors.joining(", "));

        return "RentalAgency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", availableVehicles=[" + availableVehicles + "]" +
                ", unavailableVehicles=[" + unavailableVehicles + "]" +
                '}';
    }
}