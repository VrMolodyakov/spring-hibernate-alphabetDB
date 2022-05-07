package com.example.HiberTest.Entities;


import javax.persistence.*;

@Entity
@Table(name = "sub_str")
public class subStr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "str_id")
    private Integer id;


    @Column(name = "str")
    private String str;

    public subStr(){};

    public Integer getId() {
        return id;
    }

    public String getStr() {
        return str;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public subStr(String str){
        this.str = str;
    }

    @Override
    public String toString(){
        return "id: " + id + "\r\n"+
                "str: " + str;
    }
}
