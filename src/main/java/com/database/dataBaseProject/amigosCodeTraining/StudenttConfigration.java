package com.database.dataBaseProject.amigosCodeTraining;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudenttConfigration {

    @Bean
    CommandLineRunner commandLineRunner(StudenttRepository studenttRepository){
        return args -> {
            Studentt baha  = new Studentt(
                    1l,
                    "Baha",
                    "bhajahmad99@gmail.com",
                    LocalDate.of(1999, Month.MARCH,26)

            );
            Studentt obay  = new Studentt(
                    2l,
                    "Obay",
                    "obayNaffa@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,14)

            );
            Studentt mhmd  = new Studentt(
                    3l,
                    "Mohammad",
                    "mohNaffa@gmail.com",
                    LocalDate.of(1999, Month.OCTOBER,16)

            );

            studenttRepository.saveAll(
                    List.of(baha,obay,mhmd)
            );
        };
    }
}
