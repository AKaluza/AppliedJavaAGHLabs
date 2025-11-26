package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FixDictionaryTest {

    private static FixDictionary fixDictionary;

    @Test
    public void testGetStore() {
        assertDoesNotThrow(() -> {
            assertNull(fixDictionary.getValueForKey("PossDupFlag"), "Should return null for nonexistent key");
            assertEquals(35, fixDictionary.getValueForKey("MsgType"));
            assertEquals(49, fixDictionary.getValueForKey("SenderCompID"));
            assertEquals(56, fixDictionary.getValueForKey("TargetCompID"));
        });
    }

    @BeforeAll
    public static void prepareDictionary() {
        fixDictionary = new FixDictionary();
        fixDictionary.putValueForKey("MsgType", 35);
        fixDictionary.putValueForKey("SenderCompID", 49);
        fixDictionary.putValueForKey("TargetCompID", 56);
    }
}
