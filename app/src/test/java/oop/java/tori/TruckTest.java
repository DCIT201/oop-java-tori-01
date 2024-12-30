package app.src.test.java.oop.java.tori;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.src.main.java.oop.java.tori.customer.Customer;
import app.src.main.java.oop.java.tori.vehicle.Truck;

public class TruckTest {

    private Truck truck;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        // Initialize the Truck object and the Customer object before each test
        truck = new Truck("T123", "Ford F-150", 100.0, true);
        customer = new Customer("001", "John Doe", true, true, false, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void testCalculateRentalCost_withinFreeDays() {
        int days = 29; // Within the free rental days
        double expectedCost = 29 * 100.0; // No extra charge for days over the free limit
        double actualCost = truck.calculateRentalCost(days);
        assertEquals(expectedCost, actualCost, "Rental cost should be calculated correctly within free days.");
    }

    @Test
    public void testCalculateRentalCost_withExtraDays() {
        int days = 60;
        double expectedCost = 6100.0;
        double actualCost = truck.calculateRentalCost(days);
        assertEquals(expectedCost, actualCost, "Rental cost should include the extra charge for overage days.");
    }

    @Test
    public void testIsAvailableForRental_true() {
        assertTrue(truck.isAvailableForRental(), "Truck should be available for rental.");
    }

    @Test
    public void testRent_withNegativeDays() {
        // Trying to rent with invalid number of days
        truck.rent(customer, -1);
        // In a real test, we could capture the output to validate the message.
        // But for simplicity, we'll assert that the truck is still available.
        assertTrue(truck.getIsAvailable(), "Truck should remain available if rental days are invalid.");
    }

    @Test
    public void testRent_withZeroDays() {
        // Trying to rent with 0 days
        truck.rent(customer, 0);
        // Again, checking that the truck is still available
        assertTrue(truck.getIsAvailable(), "Truck should remain available if rental days are zero.");
    }

    @Test
    public void testRent_withMoreThanMaxDays() {
        // Trying to rent for more than the maximum allowed days
        truck.rent(customer, 91); // 91 exceeds the max limit of 90
        // Truck should remain available
        assertTrue(truck.getIsAvailable(), "Truck should remain available if rental days exceed the maximum.");
    }

    @Test
    public void testRent_withEligibleCustomer() {
        // Trying to rent with a valid customer
        customer.setHasTruckLicense(true);
        truck.rent(customer, 30); // Valid rental
        assertFalse(truck.getIsAvailable(), "Truck should no longer be available after renting.");
    }

    @Test
    public void testRent_withIneligibleCustomer() {
        // Trying to rent with an ineligible customer
        customer.setHasTruckLicense(false);
        truck.rent(customer, 30);
        assertTrue(truck.getIsAvailable(), "Truck should remain available if customer is ineligible.");
    }

    @Test
    public void testRent_withNoTruckLicense() {
        // Trying to rent with a customer who doesn't have a truck license
        customer.setHasTruckLicense(false);
        truck.rent(customer, 30);
        assertTrue(truck.getIsAvailable(), "Truck should remain available if customer doesn't have a truck license.");
    }

    @Test
    public void testReturnVehicle() {
        // Testing the return vehicle functionality
        truck.setIsAvailable(false); // Simulate the truck being rented
        truck.returnVehicle();
        assertTrue(truck.getIsAvailable(), "Truck should be available after being returned.");
    }

    @Test
    public void testReturnVehicle_withCustomer() {
        // Simulate renting and returning the truck through a customer
        truck.setIsAvailable(false); // Simulate the truck being rented
        truck.returnVehicle(customer);
        assertTrue(truck.getIsAvailable(), "Truck should be available after being returned by customer.");
    }
}
