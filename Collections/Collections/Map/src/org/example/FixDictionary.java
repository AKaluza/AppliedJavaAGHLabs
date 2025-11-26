package org.example;

import java.util.HashMap;

public class FixDictionary {
    HashMap<String, Integer> values = new HashMap<>();

    public void putValueForKey(String key, int value) {
        values.put(key, value);
    }
    public Integer getValueForKey(String key) {
        Integer result = values.get(key);
        return result;
    }
}
