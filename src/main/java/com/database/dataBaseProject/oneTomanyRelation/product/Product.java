package com.database.dataBaseProject.oneTomanyRelation.product;

import com.database.dataBaseProject.oneTomanyRelation.categories.Category;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(name = "prod_seq",sequenceName = "prod_seq",allocationSize = 1)
    @GeneratedValue(
            generator = "prod_seq",
            strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 128,nullable = false,unique = true)
    private String name;
    private float price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(Integer id, String name, float price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
