package app.src.test.java.oop.java.tori;

import app.src.main.java.oop.java.tori.customer.Customer;
import app.src.main.java.oop.java.tori.rental.RentalTransaction;
import app.src.main.java.oop.java.tori.vehicle.Car;
import app.src.main.java.oop.java.tori.vehicle.Motorcycle;
import app.src.main.java.oop.java.tori.vehicle.Vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;
    private Vehicle car;
    private Vehicle motorcycle;
    private Vehicle truck;

    @BeforeEach
    void setUp() {
        car = new Car("Car1", "Toyota", 0.5, true);
        motorcycle = new Motorcycle("bike1", "Suzuki", 0.4, true);
        truck = new Motorcycle("truck1", "Tata", 0.9, true);
        customer = new Customer(
                "CUST001",
                "John Doe",
                true,
                true,
                false,
                new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    void testGetCustomerId() {
        assertEquals("CUST001", customer.getCustomerId());
    }

    @Test
    void testGetCustomerName() {
        assertEquals("John Doe", customer.getCustomerName());
    }

    @Test
    void testCustomerEligibilityToRent() {
        assertTrue(customer.isCustomerEligibleToRent());
        customer.addRental(car);
        customer.addRental(motorcycle);
        customer.addRental(truck);
        assertFalse(customer.isCustomerEligibleToRent());
    }

    @Test
    void testAddAndRemoveRental() {
        assertEquals(0, customer.getRentals().size());

        customer.addRental(car);
        assertEquals(1, customer.getRentals().size());
        assertEquals(car, customer.getRentals().get(0));

        customer.removeRental(car);
        assertEquals(0, customer.getRentals().size());
    }

    @Test
    void testAddRentalTransaction() {
        assertEquals(0, customer.getRentalTransactions().size());

        customer.addRentalTransaction(customer, car, 7);
        assertEquals(1, customer.getRentalTransactions().size());

        RentalTransaction transaction = customer.getRentalTransactions().get(0);
        assertEquals("CUST001", transaction.getCustomerId());
        assertEquals(car, transaction.getVehicle());
        assertEquals(7, transaction.getNumberOfDays());
    }

    @Test
    void testLicenses() {
        assertTrue(customer.getHasCarLicense());
        assertTrue(customer.getHasMotorcycleLicense());
        assertFalse(customer.getHasTruckLicense());
    }

    @Test
    void testToString() {
        String expected = "Customer{customerId='CUST001', customerName='John Doe', hasCarLicense=true, hasMotorcycleLicense=true, hasTruckLicense=false, rentedVehicles=[], rentalTransactions=[]}";
        assertEquals(expected, customer.toString());
    }
}
