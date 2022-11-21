package com.database.dataBaseProject.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserDetails {
    @Id
    @SequenceGenerator(
            name = "seq_id",
            sequenceName = "seq_id",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            generator = "seq_id"
    )
    private Long id;
    private String name;
    private String role;

    public  UserDetails(){}

    public UserDetails(String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
