package com.example.bonchfood;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DishTypeController {
    public DishTypeController(DishTypeRepository repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final DishTypeRepository repo;

    @GetMapping("/categories")
    public String listCategories(Model model){
        List<DishType> listCategories = repo.findAll();

        model.addAttribute("listCategories", listCategories);

        return "categories";
    }

    @GetMapping("/categories/new")
    public String showCategoryNewForm(Model model){
        model.addAttribute("category", new DishType());

        return "category_form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(DishType dish){
        repo.save(dish);

        return "redirect:/categories";
    }


    @GetMapping("categories/edit/{id}")
    public String showEditCategoriesForm(@PathVariable("id") Integer id, Model model) {
        DishType dishType = repo.findById(id).get();
        model.addAttribute("category", dishType);

        return "category_form";
    }

    @GetMapping("categories/delete/{id}")
    public String deleteCategories(@PathVariable("id") Integer id, Model model) {
        repo.deleteById(id);

        return "redirect:/categories";
    }

}