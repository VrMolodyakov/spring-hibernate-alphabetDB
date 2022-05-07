package com.example.HiberTest.Text;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component("TextParser")
@PropertySource("classpath:file.properties")
public class TextParser {
    private String parseString;
    //"C:\\Users\\Loken\\Desktop\\textForTest.txt"
    @Value("${file.name}")
    String filePath;

    public TextParser() {
        parseString = "";
    }

    public String getParseText() throws IOException {
        String testing = new String(Files.readAllBytes(Paths.get(filePath)),
                StandardCharsets.UTF_8);
        return parseString = testing.replaceAll("[^ а-яА-Я0-9.,!?:\"%\\-+=/]" ,  "")
                .replaceAll("([ .?,:!'])\\1+", "$1");

    }

    public Integer getTextLength(){
        return parseString.length();
    }
}
