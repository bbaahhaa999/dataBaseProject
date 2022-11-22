package com.database.dataBaseProject.oneTomanyRelation.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private  CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/categories")
    public String listCategories(Model model){
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("listCategories",listCategories);
        model.addAttribute("title","Category Page");
        return "categories/categories";
    }

    @GetMapping("/categories/new")
    public String showCategoryNewForm(Model model){
        model.addAttribute("title","Create New Category");
        model.addAttribute("category", new Category());
        return "categories/category_form";
    }

    @PostMapping("categories/save")
    public String saveCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/categories";
    }
}
