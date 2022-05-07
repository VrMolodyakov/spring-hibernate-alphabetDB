package com.example.HiberTest.Algorithm;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;

@Component
public class AlgorithmImpl implements statAlgorithm {
    @Override
    public HashMap<String, Integer> analysis(String textForStat) {

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        //char[] chars = text.toUpperCase(Locale.ROOT).toCharArray();
        String text = textForStat.toUpperCase(Locale.ROOT);


        for (int i = 0; i < text.length()-3; i++) {

           /* map.merge(String.valueOf(chars[i]),1,(oldVal,newVal) -> oldVal+1);
            map.merge(String.valueOf(chars[i]) + String.valueOf(chars[i+1]),1,(oldVal,newVal) -> oldVal+1);
            map.merge(String.valueOf(chars[i]) + String.valueOf(chars[i+1]) +String.valueOf(chars[i+2]),1,(oldVal,newVal) -> oldVal+1);
            map.merge(String.valueOf(chars[i] + String.valueOf(chars[i+1]) +String.valueOf(chars[i+2]) +String.valueOf(chars[i+3])),1,(oldVal,newVal) -> oldVal+1);*/

            map.merge(text.substring(i,i+1),1,(oldVal,newVal) -> oldVal+1);
            map.merge(text.substring(i,i+2),1,(oldVal,newVal) -> oldVal+1);
            map.merge(text.substring(i,i+3),1,(oldVal,newVal) -> oldVal+1);
            map.merge(text.substring(i,i+4),1,(oldVal,newVal) -> oldVal+1);

        }
        // Абажважжаф
        return map;
    }
}
