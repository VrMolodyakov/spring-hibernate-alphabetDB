package com.example.HiberTest.StatPrinter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Service
public class statPrinterImpl implements statPrinter<String,Integer>{

    Logger logger = LoggerFactory.getLogger(statPrinterImpl.class);

    @Value("${input.file.name}")
    Path filePath;

    @Override
    public void getStatPrinted(Map<String, Integer> map) {
        try {
            Files.write(filePath, () -> map.entrySet().stream()
                    .<CharSequence>map(e -> e.getKey() + " < --- > " + e.getValue())
                    .iterator());
        }catch (Exception e){
            logger.debug("file doesn't exist!");
        }
    }
}
