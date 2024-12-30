package app.src.main.java.oop.java.tori.interfaces;

import app.src.main.java.oop.java.tori.customer.Customer;

public interface Rentable {
    void rent(Customer customer, int days);

    void returnVehicle();

    void returnVehicle(Customer customer);
}