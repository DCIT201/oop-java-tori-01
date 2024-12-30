package app.src.test.java.oop.java.tori;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.src.main.java.oop.java.tori.rating.Rating;

public class RatingTest {

    private Rating rating;

    @BeforeEach
    void setUp() {
        rating = new Rating(5.0, "12345");
    }

    @Test
    void testConstructorInitialization() {
        assertEquals(5.0, rating.getRating(), "Rating value should be initialized correctly");
        assertEquals("12345", rating.getRater(), "Rater ID should be initialized correctly");
    }

    @Test
    void testSetValueWithinRange() {
        rating.setValue(7.5);
        assertEquals(7.5, rating.getRating(), "Rating value should be updated correctly");
    }

    @Test
    void testSetValueBelowMinimum() {
        rating.setValue(-1);
        assertEquals(5.0, rating.getRating(), "Rating value should not change when setting below minimum");
    }

    @Test
    void testSetValueAboveMaximum() {
        rating.setValue(11);
        assertEquals(5.0, rating.getRating(), "Rating value should not change when setting above maximum");
    }

    @Test
    void testSetRaterIdWithValidValue() {
        rating.setRaterId("67890");
        assertEquals("67890", rating.getRater(), "Rater ID should be updated correctly");
    }

    @Test
    void testSetRaterIdWithEmptyValue() {
        rating.setRaterId("");
        assertEquals("12345", rating.getRater(), "Rater ID should not change when setting empty value");
    }
}
