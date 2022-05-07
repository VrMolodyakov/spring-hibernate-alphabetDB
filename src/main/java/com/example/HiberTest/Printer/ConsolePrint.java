package com.example.HiberTest.Printer;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrint implements Printer{
    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
