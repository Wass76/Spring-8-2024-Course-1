package com.SpringCourse.Startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("all-students")
    public List<Student> getAllStudent(){
        return studentService.getAll();
    }

    @PostMapping
    public Student addStudent(Student student){
        return studentService.save(student);
    }

    @GetMapping("by-id")
    public Student getStudentById(int id){
        return studentService.getById(id);
    }

    @GetMapping("by-name")
    public List<Student> getStudentByName(String name){
        return studentService.getStudentByFirstName(name);
    }

    @DeleteMapping
    public void deleteStudentById(int id){
        studentService.deleteById(id);
    }

    @PutMapping
    public Student updateStudent(Student student){
        return studentService.updateStudent(student);
    }


}
