package com.SpringCourse.Startup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(
            generator = "student_id",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String name;
    private LocalDate birthdate;
    private double mark;
    private int age;

   public Student(){
        System.out.println("Student Constructor");
    }

    public Student(int id, String name, LocalDate birthdate, double mark, int age) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.mark = mark;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
