package com.example.bonchfood;

import jakarta.persistence.*;

@Entity
@Table(name = "dishes")
public class Dishes {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")// unique = true)
    private String name;
//
//    @Column(name = "type_id")
//    private Integer type_id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private DishType dishType;

    public Dishes() {
    }

    public Dishes(String name, DishType dishType) {
        this.name = name;
        this.dishType = dishType;
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

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }
}
