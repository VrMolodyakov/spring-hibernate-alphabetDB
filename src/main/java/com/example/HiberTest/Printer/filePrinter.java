package com.example.HiberTest.Printer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@PropertySource("classpath:file.properties")
@Service
public class filePrinter implements Printer{

    @Value("${output.file.name}")
    String filePath;

    @Override
    public void print(String str) throws IOException {
        Files.write( Paths.get(filePath), str.getBytes(StandardCharsets.UTF_8));
    }
}
