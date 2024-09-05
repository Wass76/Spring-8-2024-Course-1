package com.SpringCourse.Startup;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id
    @SequenceGenerator(
            name = "student_id",
            sequenceName = "student_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_id")
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private LocalDate birthday;
    private int age;
    private int mark;


}
