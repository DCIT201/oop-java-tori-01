package app.src.test.java.oop.java.tori;

import app.src.main.java.oop.java.tori.customer.Customer;
import app.src.main.java.oop.java.tori.vehicle.Motorcycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class MotorcycleTest {
    private Motorcycle motorcycle;
    private Customer customer;

    @BeforeEach
    void setUp() {
        motorcycle = new Motorcycle("M123", "Yamaha R1", 50.0, true);
        customer = new Customer("", "John Doe", true, true, false, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    void testCalculateRentalCost() {
        double costFor30Days = motorcycle.calculateRentalCost(30);
        assertEquals(1505.0, costFor30Days, 0.01);

        double costFor90Days = motorcycle.calculateRentalCost(90);
        assertEquals(4515.0, costFor90Days, 0.01);
    }

    @Test
    void testIsAvailableForRental() {
        assertTrue(motorcycle.isAvailableForRental());
    }

    @Test
    void testRentMotorcycleSuccessfully() {
        motorcycle.rent(customer, 30);
        assertFalse(motorcycle.getIsAvailable());
        assertTrue(customer.getRentals().contains(motorcycle));
    }

    @Test
    void testRentWithInvalidDays() {
        motorcycle.rent(customer, 0);
        assertTrue(motorcycle.getIsAvailable());

        motorcycle.rent(customer, -5);
        assertTrue(motorcycle.getIsAvailable());
    }

    @Test
    void testRentExceedingMaxDays() {
        motorcycle.rent(customer, 100);
        assertTrue(motorcycle.getIsAvailable());
    }

    @Test
    void testRentWithoutLicense() {
        customer.setHasMotorcycleLicense(false);
        motorcycle.rent(customer, 30);
        assertTrue(motorcycle.getIsAvailable());
    }

    @Test
    void testRentWhenNotAvailable() {
        motorcycle.setIsAvailable(false);
        motorcycle.rent(customer, 30);
        assertFalse(customer.getRentals().contains(motorcycle));
    }

    @Test
    void testReturnVehicle() {
        motorcycle.rent(customer, 30);
        motorcycle.returnVehicle();
        assertTrue(motorcycle.getIsAvailable());
    }

    @Test
    void testReturnVehicleWithCustomer() {
        motorcycle.rent(customer, 30);
        motorcycle.returnVehicle(customer);
        assertTrue(motorcycle.getIsAvailable());
        assertFalse(customer.getRentals().contains(motorcycle));
    }
}
