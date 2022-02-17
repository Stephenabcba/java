package com.stephenlee.studentroster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stephenlee.studentroster.models.Student;
import com.stephenlee.studentroster.services.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/students")
    public List<Student> students(Model model, @ModelAttribute("student") Student student) {
        return studentService.allStudents();
    }
    
    @GetMapping("/students/new")
    public Student create(@RequestParam("name") String Name) {
        return studentService.createStudent(new Student(Name));
    }
}

