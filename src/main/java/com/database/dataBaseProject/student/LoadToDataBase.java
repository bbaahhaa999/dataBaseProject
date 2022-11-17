package com.database.dataBaseProject.student;

import com.database.dataBaseProject.Employee;
import com.database.dataBaseProject.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadToDataBase {
    Logger logger = LoggerFactory.getLogger(LoadToDataBase.class);

    @Bean
    CommandLineRunner intDataBase(StudentRepository studentRepository, EmployeeRepository employeeRepository) {
        return args -> {
            logger.info("Preloading "+ studentRepository.save(new Student("Baha","bhajahmad@gmail.com",Gender.MALE)));
            logger.info("Preloading "+ studentRepository.save(new Student("H","bh@gmail.com",Gender.FEMALE)));
            logger.info("Preloading "+ studentRepository.save(new Student("abed","abed@gmail.com",Gender.MALE)));

            logger.info("Preloading "+ employeeRepository.save(new Employee("Baha","HajAhmad", "bhajAhmad@gmail.com")));
            logger.info("Preloading "+ employeeRepository.save(new Employee("Mujahed","Kurasaneh", "Mujahed@gmail.com")));
        };
    }
}
