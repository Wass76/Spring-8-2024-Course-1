package com.SpringCourse.Startup;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_id"
    )
    @SequenceGenerator(
            allocationSize = 1,
            name = "course_id",
            sequenceName = "course_id"
    )
    private Integer id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;

}
