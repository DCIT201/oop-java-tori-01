package app.src.main.java.oop.java.tori.rating;

public class Rating {
    private double value;
    private String raterId;

    public Rating(double value, String raterId) {
        this.value = value;
        this.raterId = raterId;
    }

    public void setValue(double value) {
        if (value < 0) {
            System.out.println("Rating cannot be negative");
            return;
        }

        if (value > 10) {
            System.out.println("Maximum rating is 10");
            return;
        }

        this.value = value;

    }

    public void setRaterId(String raterId) {
        if (raterId.isEmpty()) {
            System.out.println("Rater ID cannot be empty");
            return;
        }

        this.raterId = raterId;
    }

    public double getRating() {
        return value;
    }

    public String getRater() {
        return raterId;
    }

}
