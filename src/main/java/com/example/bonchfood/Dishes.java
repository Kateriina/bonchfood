package com.example.bonchfood;

import jakarta.persistence.*;

@Entity
@Table(name = "dishes")
public class Dishes {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_id")
    private Integer type_id;

    public Dishes() {
    }

    public Dishes(String name, Integer type_id) {
        this.name = name;
        this.type_id = type_id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }
}
