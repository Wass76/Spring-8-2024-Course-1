package com.SpringCourse.Startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public ResponseEntity<?> save(StudentRequest request)  {


        if(request.getFirstName().length()>5) throw new MyException("wrong length");
        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthday(request.getBirthday())
                .age(LocalDate.now().getYear()-request.getBirthday().getYear())
                .mark(0)
                .build();
        studentRepository.save(student);
        StudentResponse response = StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthday(student.getBirthday())
                .age(student.getAge())
                .mark(student.getMark())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(student);

    }
    public ResponseEntity getAll(){
        List<Student> students =  studentRepository.findAll();
        List<StudentResponse> responses= new ArrayList<>();
        for(Student student : students){
            StudentResponse response = StudentResponse.builder()
                    .id(student.getId())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .birthday(student.getBirthday())
                    .age(student.getAge())
                    .mark(student.getMark())
                    .build();
            responses.add(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }
    public List<Student> getStudentByFirstName(String name){
        return studentRepository.findByFirstName(name).orElse(null);
    }
    public ResponseEntity getById(Integer id){
        Student student  = studentRepository.findById(id).orElse(null);
        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
        StudentResponse response = StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthday(student.getBirthday())
                .age(student.getAge())
                .mark(student.getMark())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
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
