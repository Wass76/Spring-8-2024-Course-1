package com.SpringCourse.Startup.attendance;

import com.SpringCourse.Startup.student.Student;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "attendance_id"
    )
    @SequenceGenerator(
            allocationSize = 1,
            name = "attendance_id",
            sequenceName = "attendance_id"
    )
    private Integer id;
    private LocalDate date;

    @ManyToOne
    private Student student;


}
