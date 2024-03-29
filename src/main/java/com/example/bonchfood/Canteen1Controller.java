package com.example.bonchfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Canteen1Controller {

    public Canteen1Controller(Canteen1Repository repo) {
        this.cantRepo = repo;
    }

    @Autowired
    private final Canteen1Repository cantRepo;

    @Autowired
    private DishesRepository productRepo;

    @Autowired
    private DishTypeRepository typeRepo;


    @GetMapping("/canteen1")
    public String listCanteen(Model model){
        List<Canteen1> listCanteen = cantRepo.findAll();
        model.addAttribute("listCanteen", listCanteen);

        List<DishType> listCategories = typeRepo.findAll();
        model.addAttribute("listCategories", listCategories);

        return "canteen1";
    }

//    @GetMapping("/canteen1/add/{id}")
    @GetMapping("/canteen1/add")
//    public String showNewDishesForm(@PathVariable("id") Integer id, Model model) {
    public String showNewDishesForm( Model model) {
        List<Dishes> listDishes = productRepo.findAll();

        model.addAttribute("cant", new Canteen1());
        model.addAttribute("listDishes", listDishes);

        return "canteen1_form";
    }

    @GetMapping("canteen1/delete/{id}")
    public String deleteCategories(@PathVariable("id") Integer id, Model model) {
        cantRepo.deleteById(id);

        return "redirect:/canteen1";
    }
    @PostMapping("/canteen1/save")
    public String saveCanteen(Canteen1 cant) {
        cantRepo.save(cant);

        return "redirect:/canteen1";
    }

}