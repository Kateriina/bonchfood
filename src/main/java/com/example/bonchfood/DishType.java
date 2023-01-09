package com.example.bonchfood;

import jakarta.persistence.*;

@Entity
@Table(name = "dish_type")
public class DishType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    public DishType() {
    }

    public DishType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
