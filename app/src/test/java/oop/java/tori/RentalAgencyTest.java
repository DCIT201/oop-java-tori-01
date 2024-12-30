package app.src.test.java.oop.java.tori;

import app.src.main.java.oop.java.tori.rental.RentalAgency;
import app.src.main.java.oop.java.tori.vehicle.Car;
import app.src.main.java.oop.java.tori.vehicle.Truck;
import app.src.main.java.oop.java.tori.vehicle.Vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RentalAgencyTest {

    private RentalAgency rentalAgency;

    @BeforeEach
    public void setUp() {
        rentalAgency = new RentalAgency("001", "Tori Rentals");
    }

    @Test
    public void testSetId_ValidId() {
        rentalAgency.setId("002");
        assertEquals("002", rentalAgency.getId());
    }

    @Test
    public void testSetId_EmptyId() {
        rentalAgency.setId("");
        assertEquals("001", rentalAgency.getId()); // ID should remain unchanged
    }

    @Test
    public void testSetName_ValidName() {
        rentalAgency.setName("Tori Car Rentals");
        assertEquals("Tori Car Rentals", rentalAgency.getName());
    }

    @Test
    public void testSetName_EmptyName() {
        rentalAgency.setName("");
        assertEquals("Tori Rentals", rentalAgency.getName()); // Name should remain unchanged
    }

    @Test
    public void testAddVehicle() {
        Car car = new Car("V001", "Car", 0.5, true);
        rentalAgency.addVehicle(car);
        assertTrue(rentalAgency.getAvailableVehicles().contains(car));
    }

    @Test
    public void testAddVehicleList() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("V001", "Car", 0, true));
        vehicles.add(new Truck("V002", "Truck", 0, false));

        rentalAgency.addVehicle(vehicles);
        assertEquals(2, rentalAgency.getAllVehicles().size());
    }

    @Test
    public void testRemoveVehicle() {
        Car car = new Car("V001", "Car", 0, true);
        rentalAgency.addVehicle(car);
        rentalAgency.removeVehicle(car);
        assertFalse(rentalAgency.getAvailableVehicles().contains(car));
    }

    @Test
    public void testRemoveVehicleList() {
        List<Vehicle> vehicles = new ArrayList<>();
        Car car = new Car("V001", "Car", 0, true);
        Truck truck = new Truck("V002", "Truck", 0, false);
        vehicles.add(car);
        vehicles.add(truck);

        rentalAgency.addVehicle(vehicles);
        rentalAgency.remoteVehicle(vehicles);
        assertFalse(rentalAgency.getAvailableVehicles().contains(car));
        assertFalse(rentalAgency.getAvailableVehicles().contains(truck));
    }

    @Test
    public void testGetAvailableVehicles() {
        Car availableVehicle = new Car("V001", "Car", 0, true);
        Truck unavailableVehicle = new Truck("V002", "Truck", 0, false);

        rentalAgency.addVehicle(availableVehicle);
        rentalAgency.addVehicle(unavailableVehicle);

        List<Vehicle> availableVehicles = rentalAgency.getAvailableVehicles();
        assertEquals(1, availableVehicles.size());
        assertTrue(availableVehicles.contains(availableVehicle));
    }

    @Test
    public void testGetUnavailableVehicles() {
        Car availableVehicle = new Car("V001", "Car", 0, true);
        Truck unavailableVehicle = new Truck("V002", "Truck", 0, false);

        rentalAgency.addVehicle(availableVehicle);
        rentalAgency.addVehicle(unavailableVehicle);

        List<Vehicle> unavailableVehicles = rentalAgency.getUnvailableVehicles();
        assertEquals(1, unavailableVehicles.size());
        assertTrue(unavailableVehicles.contains(unavailableVehicle));
    }

    @Test
    public void testToString() {
        Car availableVehicle = new Car("V001", "Car", 0, true);
        Truck unavailableVehicle = new Truck("V002", "Truck", 0, false);

        rentalAgency.addVehicle(availableVehicle);
        rentalAgency.addVehicle(unavailableVehicle);

        String expectedOutput = "RentalAgency{id='001', name='Tori Rentals', availableVehicles=[Vehicle{vehicleId='V001', model='Car', baseRentalRate=0.0, isAvailable=true}], unavailableVehicles=[Vehicle{vehicleId='V002', model='Truck', baseRentalRate=0.0, isAvailable=false}]}";
        assertEquals(expectedOutput, rentalAgency.toString());
    }
}
