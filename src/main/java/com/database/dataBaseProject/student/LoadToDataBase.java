package com.database.dataBaseProject.student;

import com.database.dataBaseProject.Employee;
import com.database.dataBaseProject.EmployeeRepository;
import com.database.dataBaseProject.todo.Todo;
import com.database.dataBaseProject.todo.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadToDataBase {
    Logger logger = LoggerFactory.getLogger(LoadToDataBase.class);

    @Bean
    CommandLineRunner intDataBase(StudentRepository studentRepository, EmployeeRepository employeeRepository, TodoRepository todoRepository) {
        return args -> {
            logger.info("Preloading "+ studentRepository.save(new Student("Baha","bhajahmad@gmail.com",Gender.MALE)));
            logger.info("Preloading "+ studentRepository.save(new Student("H","bh@gmail.com",Gender.FEMALE)));
            logger.info("Preloading "+ studentRepository.save(new Student("abed","abed@gmail.com",Gender.MALE)));

            logger.info("Preloading "+ employeeRepository.save(new Employee("Baha","HajAhmad", "bhajAhmad@gmail.com")));
            logger.info("Preloading "+ employeeRepository.save(new Employee("Mujahed","Kurasaneh", "Mujahed@gmail.com")));
            logger.info("Preloading "+ todoRepository.save(new Todo(4,"Baha","AWS", LocalDate.now().plusYears(1),false)));
            logger.info("Preloading "+ todoRepository.save(new Todo(5,"Haj","JS", LocalDate.now().plusYears(2),false)));
            logger.info("Preloading "+ todoRepository.save(new Todo(6,"Ahmad","CSS", LocalDate.now().plusYears(3),false)));
            logger.info("Preloading "+ todoRepository.save(new Todo(7,"Ase","HTML", LocalDate.now().plusYears(4),false)));
        };
    }
}
