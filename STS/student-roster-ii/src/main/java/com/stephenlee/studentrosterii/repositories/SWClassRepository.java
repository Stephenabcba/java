package com.stephenlee.studentrosterii.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.studentrosterii.models.SWClass;

@Repository
public interface SWClassRepository extends CrudRepository<SWClass, Long> {
    // this method retrieves all the books from the database
    List<SWClass> findAll();
}