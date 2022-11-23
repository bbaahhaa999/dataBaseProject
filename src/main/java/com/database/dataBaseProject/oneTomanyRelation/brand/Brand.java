package com.database.dataBaseProject.oneTomanyRelation.brand;

import com.database.dataBaseProject.oneTomanyRelation.categories.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @SequenceGenerator(
            name = "brand_seq",
            sequenceName = "brand_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brand_seq"
    )
    private Integer id;
    @Column(length = 50,unique = true,nullable = false)
    private String name;

    @OneToMany

    private List<Category> categories = new ArrayList<>();
}
