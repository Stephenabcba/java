package com.stephenlee.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.projectmanager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    // this method retrieves all the tasks from the database
    List<Task> findAll();
}