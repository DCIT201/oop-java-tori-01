package app.src.test.java.oop.java.tori;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.src.main.java.oop.java.tori.rental.RentalTransaction;
import app.src.main.java.oop.java.tori.vehicle.Car;
import app.src.main.java.oop.java.tori.vehicle.Truck;

import static org.junit.jupiter.api.Assertions.*;

public class RentalTransactionTest {

    private RentalTransaction rentalTransaction;
    private Car car;

    @BeforeEach
    public void setUp() {

        car = new Car("Car123", null, 100, false);
        rentalTransaction = new RentalTransaction("C123", car, 5);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("C123", rentalTransaction.getCustomerId());
        assertEquals(car, rentalTransaction.getVehicle());
        assertEquals(5, rentalTransaction.getNumberOfDays());
    }

    @Test
    public void testSetCustomerIdValid() {
        rentalTransaction.setCustomerId("C456");
        assertEquals("C456", rentalTransaction.getCustomerId());
    }

    @Test
    public void testSetCustomerIdEmpty() {
        rentalTransaction.setCustomerId("");
        assertEquals("C123", rentalTransaction.getCustomerId());
    }

    @Test
    public void testSetVehicle() {
        Truck newVehicle = new Truck("Car456", "Tata", 150, false);
        rentalTransaction.setVehicle(newVehicle);
        assertEquals(newVehicle, rentalTransaction.getVehicle());
    }

    @Test
    public void testSetNumberOfDaysValid() {
        rentalTransaction.setNumberOfDays(10);
        assertEquals(10, rentalTransaction.getNumberOfDays());
    }

    @Test
    public void testSetNumberOfDaysInvalid() {
        rentalTransaction.setNumberOfDays(0);
        assertEquals(5, rentalTransaction.getNumberOfDays());
    }

    @Test
    public void testSetNumberOfDaysNegative() {
        rentalTransaction.setNumberOfDays(-5);
        assertEquals(5, rentalTransaction.getNumberOfDays());
    }
}
