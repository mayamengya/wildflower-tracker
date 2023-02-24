package model;

// Represents a wildflower that has a type, location and month
public class Wildflower {
    private final String type;
    private final String location;
    private final String month;

    // REQUIRES: type, location and month must be non-empty strings
    // EFFECTS: constructs a wildflower object with a type, location
    // and date.
    public Wildflower(String type, String location, String month) {
        this.type = type;
        this.location = location;
        this.month = month;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getMonth() {
        return month;
    }
}


