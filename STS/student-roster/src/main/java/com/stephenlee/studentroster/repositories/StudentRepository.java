package com.stephenlee.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    // this method retrieves all the books from the database
    List<Student> findAll();
    
    List<Student> findByDormIsNull();
}
