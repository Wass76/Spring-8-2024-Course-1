package com.SpringCourse.Startup;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getAllStudents() {
        return List.of(
                new Student(1,
                        "Wassem" ,
                        LocalDate.of(2003,11,20),
                        60,
                        21
                ),
                new Student(2,
                        "Ayman",
                        LocalDate.of(2004,10,31),
                        80,
                        20
                )
        );
    }

    public Student getFirstStudent() {
        return new Student(1,
                "Wassem" ,
                LocalDate.of(2003,11,20),
                60,
                21
        );
    }
}
