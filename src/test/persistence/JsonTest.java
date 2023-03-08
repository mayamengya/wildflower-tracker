package persistence;

import model.Wildflower;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Code structure below adapted from JsonSerializationDemo:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonTest {
    protected void checkWildflower(String type, String location, String month, Wildflower wildflower) {
        assertEquals(type, wildflower.getType());
        assertEquals(location, wildflower.getLocation());
        assertEquals(month, wildflower.getMonth());
    }
}
