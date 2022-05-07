package com.example.HiberTest.Entities;

import javax.persistence.*;

@Entity
@Table(name = "str_stat")
public class strStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text_id")
    private Integer textId;

    @Column(name = "str_id")
    private Integer strId;

    @Column(name = "count")
    private Integer count;

    @Column(name = "max_count")
    private Integer maxCount;

    public strStat( Integer textId, Integer strId, Integer count, Integer maxCount) {
        this.textId = textId;
        this.strId = strId;
        this.count = count;
        this.maxCount = maxCount;
    }

    public strStat( ) {

    }

    public Integer getId() {
        return id;
    }

    public Integer getTextId() {
        return textId;
    }

    public Integer getStrId() {
        return strId;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }

    public void setStrId(Integer strId) {
        this.strId = strId;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }
}
