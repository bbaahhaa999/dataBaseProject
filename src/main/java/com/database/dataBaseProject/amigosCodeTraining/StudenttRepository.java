package com.database.dataBaseProject.amigosCodeTraining;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudenttRepository extends JpaRepository<Studentt,Long>{
//    @Query("SELECT s FROM Studentt s WHERE s.email =?1")
    Optional<Studentt> findStudentByEmail(String email);
}
