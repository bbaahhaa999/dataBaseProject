package com.database.dataBaseProject.oneTomanyRelation.brand;

import com.database.dataBaseProject.oneTomanyRelation.categories.Category;
import com.database.dataBaseProject.oneTomanyRelation.categories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private final BrandRepository brandRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    public BrandController(BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/brands/new")
    public String addNewBrand(Model model){
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("title","Add Brand");
        model.addAttribute("brands",new Brand());
        model.addAttribute("listCategories",listCategories);
        return "brands/brands_form";
    }

    @PostMapping
    public String saveNewBrand(Brand brand){
        brandRepository.save(brand);
        return "redirect:/";
    }
}
