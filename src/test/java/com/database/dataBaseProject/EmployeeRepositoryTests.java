//package com.database.dataBaseProject;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//@DataJpaTest
//public class EmployeeRepositoryTests {
//
////  @Autowired  Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
////Only one constructor (at max) of any given bean class may carry this annotation, indicating the constructor to autowire when used as a Spring bean. Such a constructor does not have to be public.
////Fields are injected right after construction of a bean, before any config methods are invoked. Such a config field does not have to be public.
//
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Test
//    public void saveEmployeeTest(){
//
////        THIS IS A WAY TO BUILD AN OBJECT VIA LOMBOK
//        Employee employee = Employee.builder()
//                .firstName("Baha")
//                .lastName("HajAhmad")
//                .email("bhajahmad@gmail.com")
//                .build();
//
//        employeeRepository.save(employee);
////
////
//        Assertions.assertThat(employee.getId()).isGreaterThan(0);
//        System.out.println("Hello");
//
//    }
//}
