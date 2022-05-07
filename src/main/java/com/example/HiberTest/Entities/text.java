package com.example.HiberTest.Entities;

import javax.persistence.*;


@Entity
@Table(name="text")
public class text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "parent_id")
    private Integer parent_id;

    @Column(name = "name")
    private String name;

    @Column(name = "operation")
    private String operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString(){
        return String.format("id = %o" +
                        ", parent_id = %o, " +
                        "name = %s, operation = %s ",
                id,parent_id,name,operation);
    }
}
