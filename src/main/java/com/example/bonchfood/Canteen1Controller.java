package com.example.bonchfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Canteen1Controller {

    public Canteen1Controller(CanteenRepository repo) {
        this.cantRepo = repo;
    }

    @Autowired
    private final CanteenRepository cantRepo;

    @Autowired
    private DishesRepository dishRepo;

    @Autowired
    private DishTypeRepository typeRepo;

//    @GetMapping("/dishes/new")
//    public String showNewDishesForm(Model model){
//        List<DishType> listCategories = categoryRepo.findAll();
//        model.addAttribute("dish", new Dishes());
//        model.addAttribute("listCategories", listCategories);
//        return "dish_form";
//    }

//    @PostMapping("/dishes/save")
//    public String saveDish(Dishes dish){
//        cantRepo.save(dish);
//        return "redirect:/";
//    }

    @GetMapping("/canteen1")
    public String listCanteen(Model model){
        List<Canteen> listCanteen = cantRepo.findAll();
        model.addAttribute("listCanteen", listCanteen);

        List<DishType> listCategories = typeRepo.findAll();
        model.addAttribute("listCategories", listCategories);

        return "canteen1";
    }
}