package com.example.bonchfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Canteen3Controller {

    public Canteen3Controller(Canteen3Repository repo) {
        this.cantRepo = repo;
    }

    @Autowired
    private final Canteen3Repository cantRepo;

    @Autowired
    private DishesRepository productRepo;

    @Autowired
    private DishTypeRepository typeRepo;


    @GetMapping("/canteen3")
    public String listCanteen(Model model){
        List<Canteen3> listCanteen = cantRepo.findAll();
        model.addAttribute("listCanteen", listCanteen);

        List<DishType> listCategories = typeRepo.findAll();
        model.addAttribute("listCategories", listCategories);

        return "canteen3";
    }

//    @GetMapping("/canteen3/add/{id}")
    @GetMapping("/canteen3/add")
//    public String showNewDishesForm(@PathVariable("id") Integer id, Model model) {
    public String showNewDishesForm( Model model) {
        List<Dishes> listDishes = productRepo.findAll();

        model.addAttribute("cant", new Canteen3());
        model.addAttribute("listDishes", listDishes);

        return "canteen3_form";
    }

    @GetMapping("canteen3/delete/{id}")
    public String deleteCategories(@PathVariable("id") Integer id, Model model) {
        cantRepo.deleteById(id);

        return "redirect:/canteen3";
    }
    @PostMapping("/canteen3/save")
    public String saveCanteen(Canteen3 cant) {
        cantRepo.save(cant);

        return "redirect:/canteen3";
    }

}