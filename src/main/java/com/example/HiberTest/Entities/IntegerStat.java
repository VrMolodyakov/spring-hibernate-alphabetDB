package com.example.HiberTest.Entities;

import java.math.BigInteger;

public class IntegerStat {
    Integer id;
    BigInteger count;
    BigInteger possiblyCount;

    public IntegerStat(Integer id, BigInteger count, BigInteger possiblyCount) {
        this.id = id;
        this.count = count;
        this.possiblyCount = possiblyCount;
    }

    public IntegerStat() {

    }

    @Override
    public String toString() {
        return "IntegerStat{" +
                "id=" + id +
                ", count=" + count +
                ", possiblyCount=" + possiblyCount +
                '}';
    }
}
