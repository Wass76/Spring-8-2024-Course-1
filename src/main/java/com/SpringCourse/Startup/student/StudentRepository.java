package com.SpringCourse.Startup.student;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Optional<List<Student>> findByFirstName(String name);

    public List<Student> findByLastName(String name);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);




}
