package com.stephenlee.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.studentroster.models.Student;
import com.stephenlee.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;

    // returns all the students
    public List<Student> allStudents() {
        return studentRepo.findAll();
    }
    // creates a student
    public Student createStudent(Student e) {
        return studentRepo.save(e);
    }
    // retrieves a student
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }
    
    public Student updateStudent(Long id, Student newStudent) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setDorm(newStudent.getDorm());
            student.setName(newStudent.getName());
            return studentRepo.save(student);
        } else {
            return null;
        }
    }
    
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
    
    public List<Student> allDormlessStudents() {
    	return studentRepo.findByDormIsNull();
    }
}

