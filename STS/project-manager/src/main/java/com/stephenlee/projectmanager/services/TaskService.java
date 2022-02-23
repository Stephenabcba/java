package com.stephenlee.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.projectmanager.models.Task;
import com.stephenlee.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;

    // returns all the tasks, not used
    public List<Task> allTasks() {
        return taskRepo.findAll();
    }
    // creates a task
    public Task createTask(Task e) {
        return taskRepo.save(e);
    }
    // retrieves a task, not used
    public Task findTask(Long id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if(optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            return null;
        }
    }
    
    // deletes a task, not used
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}

