package com.database.dataBaseProject.amigosCodeTraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudenttService {
    @Autowired
    private final StudenttRepository studenttRepository;

    public StudenttService(StudenttRepository studenttRepository) {
        this.studenttRepository = studenttRepository;
    }
// return List.of(
//         new Studentt(1l,"Baha","bhajahmad@gmail.com", LocalDate.of(1999, Month.MARCH,26),23),
//            new Studentt(2l,"Aseel","aseelsaed@gmail.com", LocalDate.of(1990, Month.AUGUST,23),31)
//            );
    public List<Studentt> getStudents(){
       return studenttRepository.findAll();
    }

    public void addNewStudent(@RequestBody Studentt studentt) {
       Optional<Studentt> studentOptional = studenttRepository.findStudentByEmail(studentt.getEmail());
       if(studentOptional.isPresent()){
           throw new IllegalStateException("email taken");
       }
       studenttRepository.save(studentt);
    }
}
