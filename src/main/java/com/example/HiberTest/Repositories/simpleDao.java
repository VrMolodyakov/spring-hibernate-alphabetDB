package com.example.HiberTest.Repositories;

import com.example.HiberTest.Entities.textTable;

import java.util.List;

public interface simpleDao<T> {
    List<T> findAll();

    Integer save(textTable text);

    textTable findById(Integer id);

    Boolean deleteById(Integer id);

}


