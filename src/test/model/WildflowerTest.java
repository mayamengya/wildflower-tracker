package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WildflowerTest {
    private Wildflower testWildflower1;
    private Wildflower testWildflower2;
    private Wildflower testWildflower3;
    private Wildflower testWildflower4;

    @BeforeEach
    void runBefore() {
        testWildflower1 = new Wildflower("Salmonberry", "Vancouver Island", "May");
        testWildflower2 = new Wildflower("Salmonberry", "Saltspring Island", "June");
        testWildflower3 = new Wildflower("Bluebell", "Whistler", "March");
        testWildflower4 = new Wildflower("Douglas Aster", "Sunshine Coast", "August");
    }

    @Test
    void testConstructor() {
        assertEquals("Salmonberry", testWildflower1.getType());
        assertEquals("Whistler", testWildflower3.getLocation());
        assertEquals("August", testWildflower4.getMonth());
    }

    @Test
    void testGetType() {
        assertEquals("Salmonberry", testWildflower1.getType());
        assertEquals("Salmonberry", testWildflower2.getType());
        assertEquals("Bluebell", testWildflower3.getType());
        assertEquals("Douglas Aster", testWildflower4.getType());
    }

    @Test
    void testGetLocation() {
        assertEquals("Vancouver Island", testWildflower1.getLocation());
        assertEquals("Saltspring Island", testWildflower2.getLocation());
        assertEquals("Whistler", testWildflower3.getLocation());
        assertEquals("Sunshine Coast", testWildflower4.getLocation());
    }

    @Test
    void testGetMonth() {
        assertEquals("May", testWildflower1.getMonth());
        assertEquals("June", testWildflower2.getMonth());
        assertEquals("March", testWildflower3.getMonth());
        assertEquals("August", testWildflower4.getMonth());
    }
}
