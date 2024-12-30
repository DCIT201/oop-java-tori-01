package app.src.test.java.oop.java.tori;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.src.main.java.oop.java.tori.rating.Entity;
import app.src.main.java.oop.java.tori.rating.Rating;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    private Entity entity;

    @BeforeEach
    void setUp() {
        entity = new Entity();
    }

    @Test
    void testConstructorWithRatings() {
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating(4.5, "user1"));
        ratings.add(new Rating(3.0, "user2"));

        Entity entityWithRatings = new Entity(ratings);

        assertEquals(2, entityWithRatings.getRatingCount());
        assertEquals(3.75, entityWithRatings.getRating(), 0.01);
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(entity);
        assertEquals(0.0, entity.getRating(), 0.01);
    }

    @Test
    void testRateMethodAddsRating() {
        entity.rate(5.0, "user1");
        assertEquals(1, entity.getRatingCount());
        assertEquals(5.0, entity.getRating(), 0.01);

        entity.rate(3.0, "user2");
        assertEquals(2, entity.getRatingCount());
        assertEquals(4.0, entity.getRating(), 0.01);
    }

    @Test
    void testGetRatingWhenNoRatings() {
        assertEquals(0.0, entity.getRating(), 0.01);
    }

    @Test
    void testGetRatingWithMultipleRatings() {
        entity.rate(4.0, "user1");
        entity.rate(2.0, "user2");
        entity.rate(5.0, "user3");

        assertEquals(3.67, entity.getRating(), 0.01);
    }

    @Test
    void testGetRatingWithDuplicateRaters() {
        entity.rate(3.0, "user1");
        entity.rate(4.0, "user1");
        entity.rate(5.0, "user1");

        assertEquals(4.0, entity.getRating(), 0.01);
    }
}