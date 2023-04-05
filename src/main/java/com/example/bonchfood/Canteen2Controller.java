package com.example.bonchfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Canteen2Controller {

    public Canteen2Controller(Canteen2Repository repo) {
        this.cantRepo = repo;
    }

    @Autowired
    private final Canteen2Repository cantRepo;

    @Autowired
    private DishesRepository productRepo;

    @Autowired
    private DishTypeRepository typeRepo;


    @GetMapping("/canteen2")
    public String listCanteen(Model model){
        List<Canteen2> listCanteen = cantRepo.findAll();
        model.addAttribute("listCanteen", listCanteen);

        List<DishType> listCategories = typeRepo.findAll();
        model.addAttribute("listCategories", listCategories);

        return "canteen2";
    }

//    @GetMapping("/canteen2/add/{id}")
    @GetMapping("/canteen2/add")
//    public String showNewDishesForm(@PathVariable("id") Integer id, Model model) {
    public String showNewDishesForm( Model model) {
        List<Dishes> listDishes = productRepo.findAll();

        model.addAttribute("cant", new Canteen1());
        model.addAttribute("listDishes", listDishes);

        return "canteen2_form";
    }

    @GetMapping("canteen2/delete/{id}")
    public String deleteCategories(@PathVariable("id") Integer id, Model model) {
        cantRepo.deleteById(id);

        return "redirect:/canteen2";
    }
    @PostMapping("/canteen2/save")
    public String saveCanteen(Canteen2 cant) {
        cantRepo.save(cant);

        return "redirect:/canteen2";
    }

}