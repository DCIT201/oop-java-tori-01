package app.src.main.java.oop.java.tori.rating;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    private List<Rating> ratings;

    public Entity(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Entity() {
        this.ratings = new ArrayList<>();
    }

    public void rate(double value, String raterId) {
        this.ratings.add(new Rating(value, raterId));
    };

    public int getRatingCount() {
        return this.ratings.size();
    }

    public double getRating() {
        if (this.ratings.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;

        for (int i = 0; i < this.ratings.size(); i++) {
            sum += ratings.get(i).getRating();
        }

        return sum / this.ratings.size();
    }
}
