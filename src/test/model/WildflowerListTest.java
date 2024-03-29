package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WildflowerListTest {
    private WildflowerList testWildflowerList;
    private Wildflower testWildflower1;
    private Wildflower testWildflower2;
    private Wildflower testWildflower3;
    private Wildflower testWildflower4;

    @BeforeEach
    void runBefore() {
        testWildflowerList = new WildflowerList("Summer Blooms");
        testWildflower1 = new Wildflower("Salmonberry", "Vancouver Island", "May");
        testWildflower2 = new Wildflower("Salmonberry", "Saltspring Island", "June");
        testWildflower3 = new Wildflower("Bluebell", "Whistler", "March");
        testWildflower4 = new Wildflower("Douglas Aster", "Sunshine Coast", "August");
    }

    @Test
    void testConstructor() {
        assertEquals("Summer Blooms", testWildflowerList.getTitle());
        assertTrue(testWildflowerList.getWildflowerList().isEmpty());
    }

    @Test
    void addOneWildflower() {
        testWildflowerList.addWildflower(testWildflower1);
        assertEquals(1, testWildflowerList.getWildflowerList().size());

        // checking to see if all Wildflower fields are added correctly
        assertEquals("Salmonberry", testWildflowerList.getWildflowerList().get(0).getType());
        assertEquals("Vancouver Island", testWildflowerList.getWildflowerList().get(0).getLocation());
        assertEquals("May", testWildflowerList.getWildflowerList().get(0).getMonth());
    }

    @Test
    void addMultipleWildflower() {
        testWildflowerList.addWildflower(testWildflower1);
        testWildflowerList.addWildflower(testWildflower3);
        testWildflowerList.addWildflower(testWildflower4);
        assertEquals(3, testWildflowerList.getWildflowerList().size());

        // checking to see if list contains correct Wildflowers
        assertTrue(testWildflowerList.getWildflowerList().contains(testWildflower1));
        assertTrue(testWildflowerList.getWildflowerList().contains(testWildflower3));
        assertTrue(testWildflowerList.getWildflowerList().contains(testWildflower4));
    }

    @Test
    void removeOneWildflowerSuccess() {
        testWildflowerList.addWildflower(testWildflower1);
        testWildflowerList.addWildflower(testWildflower2);
        testWildflowerList.addWildflower(testWildflower3);
        assertTrue(testWildflowerList.removeWildflower("Salmonberry", "Vancouver Island", "May"));

        // checking to see if list is correct size after removing one Wildflower
        assertEquals(2, testWildflowerList.getWildflowerList().size());

        // checking to see if index of wildflower updated after removal of one Wildflower
        assertEquals("Bluebell", testWildflowerList.getWildflowerList().get(1).getType());
    }

    @Test
    void removeMultipleWildflowerSuccess() {
        testWildflowerList.addWildflower(testWildflower1);
        testWildflowerList.addWildflower(testWildflower2);
        testWildflowerList.addWildflower(testWildflower3);
        testWildflowerList.addWildflower(testWildflower4);

        // remove first Wildflower
        assertTrue(testWildflowerList.removeWildflower("Salmonberry", "Vancouver Island", "May"));

        // checking to see if size of list and index of objects are updated after removal of one Wildflower
        assertEquals(3, testWildflowerList.getWildflowerList().size());
        assertEquals("Salmonberry", testWildflowerList.getWildflowerList().get(0).getType());
        assertEquals("Saltspring Island", testWildflowerList.getWildflowerList().get(0).getLocation());
        assertEquals("June", testWildflowerList.getWildflowerList().get(0).getMonth());

        // removing  second wildflower
        assertTrue(testWildflowerList.removeWildflower
                ("Salmonberry", "Saltspring Island", "June"));

        // checking to see if size of list and index of objects are updated after removal of another Wildflower
        assertEquals(2, testWildflowerList.getWildflowerList().size());
        assertEquals("Bluebell", testWildflowerList.getWildflowerList().get(0).getType());
        assertEquals("Whistler", testWildflowerList.getWildflowerList().get(0).getLocation());
        assertEquals("March", testWildflowerList.getWildflowerList().get(0).getMonth());

        // removing the remaining wildflowers and checking to see if list is now empty
        assertTrue(testWildflowerList.removeWildflower("Bluebell", "Whistler", "March"));
        assertTrue(testWildflowerList.removeWildflower("Douglas Aster", "Sunshine Coast", "August"));
        assertTrue(testWildflowerList.getWildflowerList().isEmpty());
    }

    @Test
    void removeOneWildflowerFail() {
        testWildflowerList.addWildflower(testWildflower1);
        testWildflowerList.addWildflower(testWildflower2);
        testWildflowerList.addWildflower(testWildflower3);
        assertFalse(testWildflowerList.removeWildflower("Salmonberry", "Vancouver Island",
                "January"));

        // wildflower does not exist in list, checking to see that list is still same size and index
        assertEquals(3, testWildflowerList.getWildflowerList().size());
        assertEquals("Bluebell", testWildflowerList.getWildflowerList().get(2).getType());
    }

    @Test
    void seenBeforeSuccess() {
        testWildflowerList.addWildflower(testWildflower1);
        testWildflowerList.addWildflower(testWildflower2);
        testWildflowerList.addWildflower(testWildflower3);
        assertTrue(testWildflowerList.haveISeenThisWildflower("Salmonberry"));
    }

    @Test
    void seenBeforeFail() {
        testWildflowerList.addWildflower(testWildflower1);
        testWildflowerList.addWildflower(testWildflower2);
        testWildflowerList.addWildflower(testWildflower3);
        assertFalse(testWildflowerList.haveISeenThisWildflower("Dandelion"));
    }

    @Test
    void testGetWildflowerTypes() {
        testWildflowerList.addWildflower(testWildflower1);
        testWildflowerList.addWildflower(testWildflower2);
        testWildflowerList.addWildflower(testWildflower3);
        List<String> uniqueWildflowerTypes = testWildflowerList.getWildflowerTypes();
        assertEquals(2, uniqueWildflowerTypes.size());
        assertTrue(uniqueWildflowerTypes.contains("Salmonberry"));
        assertTrue(uniqueWildflowerTypes.contains("Bluebell"));

    }

    @Test
    void testGetWildflowerLocations() {
        testWildflowerList.addWildflower(testWildflower1);
        testWildflowerList.addWildflower(testWildflower2);
        testWildflowerList.addWildflower(testWildflower3);
        testWildflowerList.addWildflower(testWildflower4);
        List<String> locations = testWildflowerList.getWildflowerLocations("Salmonberry");
        assertEquals(2, locations.size());
        assertEquals("Vancouver Island", locations.get(0));
        assertEquals("Saltspring Island", locations.get(1));
    }


}