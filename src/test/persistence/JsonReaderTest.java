package persistence;

import model.Wildflower;
import model.WildflowerList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

// Code structure below adapted from JsonSerializationDemo:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WildflowerList wl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWildflowerList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWildflowerList.json");
        try {
            WildflowerList wl = reader.read();
            assertEquals("My wildflower list", wl.getTitle());
            assertEquals(0, wl.getWildflowerList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWildflowerList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWildflowerList.json");
        try {
            WildflowerList wl = reader.read();
            assertEquals("My wildflower list", wl.getTitle());
            List<Wildflower> wildflower = wl.getWildflowerList();
            assertEquals(2, wl.getWildflowerList().size());
            checkWildflower("bluebell","Vancouver", "May", wl.getWildflowerList().get(0));
            checkWildflower("daisy", "Victoria", "January", wl.getWildflowerList().get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
