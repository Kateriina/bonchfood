package com.example.bonchfood;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    public AppController(AppRepository repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final AppRepository repo;

    @GetMapping("/categories")
    public String listCategories(Model model){
        List<Dishes> listCategories = repo.findAll();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String showCategoryNewForm(Model model){
        model.addAttribute("category", new Dishes());
        return "category_form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Dishes dish){
        repo.save(dish);
    return "redirect:/categories";
    }

//    @GetMapping("/products")
//    public String listProducts(Model model){
////        List<Dishes> listCategories = repo.findAll();
////        model.addAttribute("listCategories", listCategories);
//        return "products";
//    }
}