package com.example.HiberTest.Repositories;

import com.example.HiberTest.Entities.subStr;

import java.util.List;

public interface subStringRepo {
    List<subStr> findALL();
    Integer save(subStr str);
    void deleteAll();
    void addSubStringFromText(List<String> recordings);
    subStr findByValue(String str);
    subStr findById(Integer id);
}
