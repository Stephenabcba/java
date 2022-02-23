package com.stephenlee.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.projectmanager.models.Project;
import com.stephenlee.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepo;

    // returns all the projects
    public List<Project> allProjects() {
        return projectRepo.findAll();
    }
    // creates a project
    public Project createProject(Project e) {
        return projectRepo.save(e);
    }
    // retrieves a project
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    
    // updates a project, changing only the title, description, and due date
    public Project updateProject(Long id, Project newProject) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setTitle(newProject.getTitle());
            project.setDescription(newProject.getDescription());
            project.setDueDate(newProject.getDueDate());
            return projectRepo.save(project);
        } else {
            return null;
        }
    }
    
    // updates a project without making any modifications
    public Project saveProject(Project project) {
    	return projectRepo.save(project);
    }
    
    //deletes a project, not used
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
}

