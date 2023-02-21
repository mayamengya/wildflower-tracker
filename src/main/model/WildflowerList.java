package model;

import java.util.ArrayList;
import java.util.List;


public class WildflowerList {
    private String title;
    private List<Wildflower> wildflowerList;

    public WildflowerList(String title) {
        wildflowerList = new ArrayList<>();
        this.title = title;
    }

    public String getTitle() {
        return title;

    }

    public List<Wildflower> getWildflowerList() {
        return wildflowerList;
    }

    // REQUIRES: type and location to be non-empty strings, date must be positive integer
    // MODIFIES: this
    // EFFECTS: adds new wildflower to list
    public void addWildflower(Wildflower wildflower) {
        wildflowerList.add(wildflower);
    }

    // MODIFIES: this
    // EFFECTS: Removes wildflower with the same type, location and month, and return true.
    // If no wildflower with the same type, location and month is found, return false.
    public Boolean removeWildflower(String type, String location, String month) {
        for (Wildflower wildflower : wildflowerList) {
            if (wildflower.getType().equals(type)
                    &&
                    wildflower.getLocation().equals(location)
                    &&
                    wildflower.getMonth().equals(month)) {
                wildflowerList.remove(wildflower);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: If wildflower with the same type as the given type is in collection,
    // return true. Otherwise, return false.

    public Boolean haveISeenThisWildflower(String type) {
        for (Wildflower wildflower : wildflowerList) {
            if (wildflower.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns a list of all wildflower types in collection
    public List<String> getWildflowerTypes() {
        List<String> wildflowerTypes = new ArrayList<>();
        for (int i = 0; i < wildflowerList.size(); i++) {
            Wildflower currentWildflower = wildflowerList.get(i);
            String currentType = currentWildflower.getType();
            if (!wildflowerTypes.contains(currentType)) {
                wildflowerTypes.add(currentType);
            }
        }
        return wildflowerTypes;
    }

    // EFFECTS: returns a list of all locations of a specific wildflower in collection
    public List<String> getWildflowerLocations(String type) {
        List<String> wildflowerLocations = new ArrayList<>();
        for (int i = 0; i < wildflowerList.size(); i++) {
            if (wildflowerList.get(i).getType().equals(type)) {
                wildflowerLocations.add(wildflowerList.get(i).getLocation());
            }
        }
        return wildflowerLocations;
    }
}


