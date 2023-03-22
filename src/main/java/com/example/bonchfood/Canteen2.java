   package com.example.bonchfood;

import jakarta.persistence.*;

   @Entity
   @Table(name = "canteen2")
   public class Canteen2 {
       @Id
       @Column(name = "id", nullable = false)
       @GeneratedValue(strategy= GenerationType.IDENTITY)
       private Integer id;
   
       @ManyToOne
       @JoinColumn(name = "dish_id")
       private Dishes dishName;
   
   //    @ManyToOne
   //    @JoinColumn(name = "type_id")
   //    private DishType dishType;
   
       public Canteen2() {
       }
   
       public Canteen2(Integer id, Dishes dishName) {
           this.id = id;
           this.dishName = dishName;
       }
   
       public Integer getId() {
           return id;
       }
   
       public void setId(Integer id) {
           this.id = id;
       }
   
       public Dishes getDishName() {
           return dishName;
       }
   
       public void setDishName(Dishes dishName) {
           this.dishName = dishName;
       }
   }
