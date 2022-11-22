package com.database.dataBaseProject.amigosCodeTraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "apii/v11/students")
public class StudenttController {

    private final StudenttService studenttService;
    @Autowired
    public StudenttController(StudenttService studenttService) {
        this.studenttService = studenttService;
    }

    @GetMapping
    public List<Studentt> getStudents(){
       return studenttService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(Studentt studentt){
        studenttService.addNewStudent(studentt);
    }
}
