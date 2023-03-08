package persistence;

import model.Wildflower;
import model.WildflowerList;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Code structure below adapted from JsonSerializationDemo:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            WildflowerList wl = new WildflowerList("My wildflower list");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test

    void testWriterEmptyWildflowerList() {
        try {
            WildflowerList wl = new WildflowerList("My wildflower list");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWildflowerList.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWildflowerList.json");
            wl = reader.read();
            assertEquals("My wildflower list", wl.getTitle());
            assertEquals(0, wl.getWildflowerList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWildflowerList() {
        try {
            WildflowerList wl = new WildflowerList("My wildflower list");
            wl.addWildflower(new Wildflower("daisy", "Whistler", "June"));
            wl.addWildflower(new Wildflower("hemlock", "Surrey", "December"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWildflowerList.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWildflowerList.json");
            wl = reader.read();
            assertEquals("My wildflower list", wl.getTitle());
            List<Wildflower> wildflower = wl.getWildflowerList();
            assertEquals(2, wildflower.size());
            checkWildflower("daisy", "Whistler", "June", wildflower.get(0));
            checkWildflower("hemlock", "Surrey", "December", wildflower.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
