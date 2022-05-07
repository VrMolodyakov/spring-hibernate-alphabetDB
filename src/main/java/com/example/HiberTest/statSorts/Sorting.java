package com.example.HiberTest.statSorts;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Sorting<K,V> {
    LinkedHashMap<K,V> sort(Map<K, V> map);
}
