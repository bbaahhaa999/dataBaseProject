package com.database.dataBaseProject.amigosCodeTraining;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
@Table(name = "stu_tbl")
public class Studentt {
    @Id
    @SequenceGenerator(name = "stu_seq", sequenceName = "stu_srq",allocationSize = 1)
    @GeneratedValue(generator = "stu_seq" ,strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private LocalDate bod;
    @Transient
    private int age;

    public Studentt(){

    }

    public Studentt(Long id, String name, String email, LocalDate bod) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bod = bod;

    }

    public Studentt(String name, String email, LocalDate bod) {
        this.name = name;
        this.email = email;
        this.bod = bod;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBod() {
        return bod;
    }

    public void setBod(LocalDate bod) {
        this.bod = bod;
    }

    public int getAge() {
        return Period.between(this.bod,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

}
