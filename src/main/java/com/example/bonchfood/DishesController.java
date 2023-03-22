package com.example.bonchfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class DishesController {

    public DishesController(DishesRepository repo) {
        this.productRepo = repo;
    }

    @Autowired
    private final DishesRepository productRepo;

    @Autowired
    private DishTypeRepository categoryRepo;

    @GetMapping("/dishes/new")
    public String showNewDishesForm(Model model) {
        List<DishType> listCategories = categoryRepo.findAll();

        model.addAttribute("dish", new Dishes());
        model.addAttribute("listCategories", listCategories);

        return "dish_form";
    }

    @PostMapping("/dishes/save")
    public String saveDish(Dishes dish) {
        productRepo.save(dish);

        return "redirect:/dishes";
    }

    @GetMapping("/dishes")
    public String listDishes(Model model) {
        List<Dishes> listDishes = productRepo.findAll();
        model.addAttribute("listDishes", listDishes);

        return "dishes";
    }

    @GetMapping("dishes/edit/{id}")
    public String showEditDishesForm(@PathVariable("id") Integer id, Model model) {
        Dishes dishes = productRepo.findById(id).get();
        model.addAttribute("dish", dishes);

        List<DishType> listCategories = categoryRepo.findAll();

        model.addAttribute("listCategories", listCategories);

        return "dish_form";
    }

    @GetMapping("dishes/delete/{id}")
    public String deleteDishes(@PathVariable("id") Integer id, Model model) {
        productRepo.deleteById(id);
        return "redirect:/dishes";
    }
}