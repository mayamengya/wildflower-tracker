package persistence;

import model.Wildflower;
import model.WildflowerList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Code structure below adapted from JsonSerializationDemo:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads a wildflower list from JSON data stored in file
public class JsonReader {
    private final String source;

    // EFFECTS: constructs a reader to read from the source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads wildflower list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WildflowerList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWildflowerList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses wildflower list from JSON object and returns it
    private WildflowerList parseWildflowerList(JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        WildflowerList wl = new WildflowerList(title);
        addWildflowers(wl, jsonObject);
        return wl;
    }

    // MODIFIES: wl
    // EFFECTS: parse wildflowers from JSON object and adds them to wildflower list
    private void addWildflowers(WildflowerList wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("wildflower");
        for (Object json : jsonArray) {
            JSONObject nextWildflower = (JSONObject) json;
            addWildflower(wl, nextWildflower);
        }
    }
    // MODIFIES: wl
    // EFFECTS: parse wildflower from JSON object and adds it to wildflower list

    private void addWildflower(WildflowerList wl, JSONObject jsonObject) {
        String type = jsonObject.getString("type");
        String location = jsonObject.getString("location");
        String month = jsonObject.getString("month");
        Wildflower wildflower = new Wildflower(type, location, month);
        wl.addWildflower(wildflower);
    }


}
