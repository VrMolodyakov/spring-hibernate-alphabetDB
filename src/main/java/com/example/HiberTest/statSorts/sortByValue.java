package com.example.HiberTest.statSorts;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class sortByValue implements Sorting<String,Integer>{
    @Override
    public LinkedHashMap<String,Integer> sort(Map<String, Integer> map) {
        return map.entrySet().stream().
                              sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                              collect(Collectors.toMap(
                                        Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
