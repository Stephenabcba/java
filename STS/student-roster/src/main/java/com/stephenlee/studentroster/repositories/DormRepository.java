package com.stephenlee.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.studentroster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
    // this method retrieves all the books from the database
    List<Dorm> findAll();
}