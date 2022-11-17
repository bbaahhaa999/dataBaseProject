package com.database.dataBaseProject.student;

import lombok.*;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@RestController
public class Student {
    @Id
    @SequenceGenerator(
            name = "stu_seq",
            sequenceName = "stu_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stu_seq"
    )
    private Long id;
    @NotBlank
    @Column(nullable = false,unique = true)
    private String name;
    @Email
    @Column(nullable = false,unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;


    public Student(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
