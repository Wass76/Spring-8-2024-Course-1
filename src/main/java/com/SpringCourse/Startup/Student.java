package com.SpringCourse.Startup;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(
            generator = "student_id",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "student_id",
            allocationSize = 1,
            sequenceName = "student_id"
    )
    private int id;
    private String name;
    private LocalDate birthdate;
    private double mark;

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



   public Student(){
        System.out.println("Student Constructor");
    }

    public Student(int id, String name, LocalDate birthdate, double mark, int age) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
