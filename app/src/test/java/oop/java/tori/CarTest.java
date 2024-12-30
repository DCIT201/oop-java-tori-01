package app.src.test.java.oop.java.tori;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.src.main.java.oop.java.tori.customer.Customer;
import app.src.main.java.oop.java.tori.vehicle.Car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class CarTest {

    private Car car;
    private Customer eligibleCustomer;
    private Customer ineligibleCustomer;

    @BeforeEach
    void setUp() {
        car = new Car("C001", "Toyota Corolla", 50.0, true);

        eligibleCustomer = new Customer("001", "John Doe", true, true, false, new ArrayList<>(), new ArrayList<>());
        ineligibleCustomer = new Customer("002", "Jane Smith", false, false, false, new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    void testCalculateRentalCost() {
        double cost = car.calculateRentalCost(35);
        assertEquals(1760.0, cost, 0.01, "Cost calculation with extra days failed");

        cost = car.calculateRentalCost(30);
        assertEquals(1510.0, cost, 0.01, "Cost calculation without remainder failed");

        cost = car.calculateRentalCost(0);
        assertEquals(0.0, cost, 0.01, "Cost for 0 days should be 0");
    }

    @Test
    void testIsAvailableForRental() {
        assertTrue(car.isAvailableForRental(), "Car should be available for rental");
    }

    @Test
    void testRent_SuccessfulRental() {
        car.rent(eligibleCustomer, 20);
        assertFalse(car.getIsAvailable(), "Car should be unavailable after rental");
        assertTrue(eligibleCustomer.getRentals().contains(car), "Customer should have the rented car");
    }

    @Test
    void testRent_FailureDueToIneligibleCustomer() {
        car.rent(ineligibleCustomer, 20);
        assertTrue(car.getIsAvailable(), "Car should remain available for rental");
        assertFalse(ineligibleCustomer.getRentals().contains(car), "Customer should not have the rented car");
    }

    @Test
    void testRent_FailureDueToExceedingMaxDays() {
        car.rent(eligibleCustomer, 120);
        assertTrue(car.getIsAvailable(), "Car should remain available for rental");
    }

    @Test
    void testRent_FailureDueToNegativeDays() {
        car.rent(eligibleCustomer, -5);
        assertTrue(car.getIsAvailable(), "Car should remain available for rental");
    }

    @Test
    void testReturnVehicle() {
        car.rent(eligibleCustomer, 20);
        car.returnVehicle();
        assertTrue(car.getIsAvailable(), "Car should be available after return");
    }

    @Test
    void testReturnVehicleWithCustomer() {
        car.rent(eligibleCustomer, 20);
        car.returnVehicle(eligibleCustomer);
        assertTrue(car.getIsAvailable(), "Car should be available after return");
        assertFalse(eligibleCustomer.getRentals().contains(car), "Customer should not have the car after return");
    }
}
