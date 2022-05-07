package com.example.HiberTest.Repositories;

import com.example.HiberTest.Entities.textTable;

import java.util.List;

public interface CrudRepo<T> {
    List<T> findAll();
    Integer save(T element);
    void deleteAll();
    List<Object[]> getSumAndGroupByStats();
}
