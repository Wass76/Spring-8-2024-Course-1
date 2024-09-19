package com.SpringCourse.Startup.student;

import com.SpringCourse.Startup.ExceptionPackage.NameException;
import com.SpringCourse.Startup.ExceptionPackage.RequestException;
import com.SpringCourse.Startup.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public ResponseEntity<?> save(StudentRequest request)  {

        String firstName = request.getFirstName();
        if(firstName.length()>5) throw new NameException("wrong length");
        for(int i =0; i<firstName.length();i++){
            if(firstName.charAt(i)<97)
                throw new NameException("there is a capital letter");
        }


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
        return studentRepository.findByFirstName(name).orElseThrow(()->new RequestException("No student found"));
    }
    public ResponseEntity getById(Integer id){
        Student student  = studentRepository.findById(id).orElseThrow(
                ()-> new RequestException("student not found")
        );

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
        Student student = studentRepository.findById(id).orElseThrow(()-> new RequestException("student not found"));
        if(student != null){
            studentRepository.deleteById(id);
        }
    }
    public  Student updateStudent(Student student){
        Student s1 = studentRepository.findById(student.getId()).orElseThrow(()-> new RequestException("student not found"));
        s1.setBirthday(student.getBirthday());
        String firstName = student.getFirstName();
        if(firstName.length()>5) throw new NameException("wrong length");
        for(int i =0; i<firstName.length();i++){
            if(firstName.charAt(i)<97)
                throw new NameException("there is a capital letter");
        }
        s1.setFirstName(s1.getFirstName());
        s1.setLastName(s1.getLastName());
        s1.setMark(student.getMark());
        s1.setAge(student.getAge());
        studentRepository.save(s1);
        return s1;
    }

}
