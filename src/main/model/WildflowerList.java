package model;

import java.util.ArrayList;
import java.util.List;


public class WildflowerList {
    private String title;
    private List<Wildflower> wildflowerCollection;

    public WildflowerList(String title) {
        wildflowerCollection = new ArrayList<>();
        this.title = title;
    }

    public String getTitle() {
        return title;

    }

    public List<Wildflower> getWildflowerCollection() {
        return wildflowerCollection;
    }

    // REQUIRES: type and location to be non-empty strings, date must be positive integer
    // MODIFIES: this
    // EFFECTS: adds new wildflower to list
    public void addWildflower(Wildflower wildflower) {
        wildflowerCollection.add(wildflower);
    }

    // MODIFIES: this
    // EFFECTS: Removes wildflower with the same type, location and date, and return true.
    // If no wildflower with the same type, location and date is found, return false.
    public Boolean removeWildflower(String type, String location, String month) {
        for (Wildflower wildflower : wildflowerCollection) {
            if (wildflower.getType().equals(type)
                    &&
                    wildflower.getLocation().equals(location)
                    &&
                    wildflower.getMonth().equals(month)) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: If wildflower with the same type as the given type is in collection,
    // return true. Otherwise, return false.

    public Boolean haveISeenThisWildflower(String type) {
        for (Wildflower wildflower : wildflowerCollection) {
            if (wildflower.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: returns a list of all wildflower types in collection
    public List<String> getWildflowerTypes(List<Wildflower> wildflower) {
        List<String> wildflowerTypes = new ArrayList<>();
        for (Wildflower currentWildflower : wildflower) {
            wildflowerTypes.add(currentWildflower.getType());
        }
        return wildflowerTypes;
    }

    // MODIFIES: this
    // EFFECTS: returns a list of all locations of a specific wildflower in collection
    public List<String> getWildflowerLocations(List<Wildflower> wildflower, String type, String location) {
        List<String> wildflowerLocations = new ArrayList<>();
        for (Wildflower currentWildflower : wildflower) {
            if (currentWildflower.getType().equals(type)) {
                wildflowerLocations.add(currentWildflower.getType());
            }
        }
        return wildflowerLocations;
    }
}


