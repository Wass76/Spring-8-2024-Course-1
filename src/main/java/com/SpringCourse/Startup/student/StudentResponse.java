package com.SpringCourse.Startup.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private int age;
    private int mark;

}
