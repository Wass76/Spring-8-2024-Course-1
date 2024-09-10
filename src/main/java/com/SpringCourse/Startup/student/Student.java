package com.SpringCourse.Startup.student;

import com.SpringCourse.Startup.course.Course;
import com.SpringCourse.Startup.wallet.Wallet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

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


    @OneToOne
    private Wallet wallet;

//    @OneToMany
//    private List<Attendance> attendanceList;

    @ManyToMany()
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns =@JoinColumn(name = "course_id")
    )
    private List<Course> courseList;




}
