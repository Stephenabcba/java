package com.stephenlee.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.projectmanager.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    // this method retrieves all the projects from the database
    List<Project> findAll();
}