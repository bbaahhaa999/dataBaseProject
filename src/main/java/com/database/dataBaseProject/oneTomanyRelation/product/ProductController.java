package com.database.dataBaseProject.oneTomanyRelation.product;

import com.database.dataBaseProject.oneTomanyRelation.categories.Category;
import com.database.dataBaseProject.oneTomanyRelation.categories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/products/new")
    public String showNewProductForm(Model model){
        List<Category> listCategory = categoryRepository.findAll();
        model.addAttribute("title","Add a new product");
        model.addAttribute("product",new Product());
        model.addAttribute("listCategory",listCategory);
        return "products/products_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String listProducts(Model model){
        List<Product> listProducts = productRepository.findAll();
        model.addAttribute("title","All Products");
        model.addAttribute("listProducts",listProducts);
        return "products/products";
    }

    @GetMapping("products/edit/{id}")
    public String showEditProductForm(@PathVariable Integer id, Model model){
        Product product = productRepository.findById(id).get();
        model.addAttribute("title","Edit Product")
        return "product/product_form";
    }


}
