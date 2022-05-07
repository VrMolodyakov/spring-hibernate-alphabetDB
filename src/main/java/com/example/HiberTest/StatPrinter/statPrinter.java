package com.example.HiberTest.StatPrinter;

import java.util.Map;

public interface statPrinter<K,V> {
    void getStatPrinted(Map<K,V> map);
}
