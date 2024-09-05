package com.SpringCourse.Startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student){
        studentRepository.save(student);
        return student;
    }
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public List<Student> getStudentByName(String name){
        return studentRepository.findByName(name).orElse(null);
    }
    public Student getById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }
    public void deleteById(Integer id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null){
            studentRepository.deleteById(id);
        }
    }
    public  Student updateStudent(Student student){
        Student s1 = studentRepository.findById(student.getId()).orElse(null);
        if(s1 != null){
            s1.setBirthday(student.getBirthday());
            s1.setFirstName(s1.getFirstName());
            s1.setLastName(s1.getLastName());
            s1.setMark(student.getMark());
            s1.setAge(student.getAge());
            studentRepository.save(s1);
        }
        return s1;
    }

}
