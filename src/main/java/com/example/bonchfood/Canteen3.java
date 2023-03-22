   package com.example.bonchfood;

import jakarta.persistence.*;

   @Entity
   @Table(name = "canteen3")
   public class Canteen3 {
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
   
       public Canteen3() {
       }
   
       public Canteen3(Integer id, Dishes dishName) {
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
