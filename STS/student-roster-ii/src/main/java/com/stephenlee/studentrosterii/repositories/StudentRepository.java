package com.stephenlee.studentrosterii.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.studentrosterii.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    // this method retrieves all the books from the database
    List<Student> findAll();
}