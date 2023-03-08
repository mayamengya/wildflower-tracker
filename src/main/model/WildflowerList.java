package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a list having a title and a list of Wildflower
public class WildflowerList implements Writable {
    private final String title;
    private final List<Wildflower> wildflowerList;

    // REQUIRES: title must be a non-empty string and initially be an empty list
    // EFFECTS: constructs a WildflowerList object with a title and an empty list
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

    // REQUIRES: type, location and month to be non-empty strings
    // MODIFIES: this
    // EFFECTS: adds a new wildflower to list
    public void addWildflower(Wildflower wildflower) {
        wildflowerList.add(wildflower);
    }

    // MODIFIES: this
    // EFFECTS: removes wildflower with the same type, location and month, and returns true
    // If no wildflower with the same type, location and month is found, return false
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

    // EFFECTS: return true if Wildflower with the same type as the given type is in collection,
    // Otherwise, return false.
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
        for (Wildflower currentWildflower : wildflowerList) {
            String currentType = currentWildflower.getType();
            if (!wildflowerTypes.contains(currentType)) {
                wildflowerTypes.add(currentType);
            }
        }
        return wildflowerTypes;
    }

    // EFFECTS: returns a list of all locations of a specific wildflower type
    public List<String> getWildflowerLocations(String type) {
        List<String> wildflowerLocations = new ArrayList<>();
        for (Wildflower wildflower : wildflowerList) {
            if (wildflower.getType().equals(type)) {
                wildflowerLocations.add(wildflower.getLocation());
            }
        }
        return wildflowerLocations;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("wildflower", wildflowersToJson());
        return json;
    }

    // EFFECTS: returns things in this wildflowerlist as a JSON array
    private JSONArray wildflowersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Wildflower w : wildflowerList) {
            jsonArray.put(w.toJson());
        }
        return jsonArray;
    }
}


