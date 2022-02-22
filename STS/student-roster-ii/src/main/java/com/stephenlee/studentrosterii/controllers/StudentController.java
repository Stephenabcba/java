package com.stephenlee.studentrosterii.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stephenlee.studentrosterii.models.SWClass;
import com.stephenlee.studentrosterii.models.Student;
import com.stephenlee.studentrosterii.services.SWClassService;
import com.stephenlee.studentrosterii.services.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private SWClassService classService;
    
    @GetMapping("/students/new")
    public String newStudentForm(@ModelAttribute("student") Student student) {
        return "addStudent.jsp";
    }
    
    @PostMapping("/students/new")
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "addStudent.jsp";
        } else {
            studentService.createStudent(student);
            return "redirect:/students/new";
        }
    }
    
    @GetMapping("/students/{id}")
    public String showStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findStudent(id);
        if (student == null) {
        	return "redirect:/students/new";
        }
        model.addAttribute("student", student);
        List<SWClass> classes = classService.allSWClasses();
        model.addAttribute("classes", classes);
        return "showStudent.jsp";
    }
    
    @PutMapping("/students/{studentId}/addClass")
    public String addClassToStudent(@PathVariable("studentId") Long studentId, @RequestParam("classToAdd") Long classToAddId) {
    	Student student = studentService.findStudent(studentId);
    	student.getClasses().add(classService.findSWClass(classToAddId));
    	studentService.saveStudent(student);
    	return "redirect:/students/" + studentId.toString();
    }
    
    @PutMapping("/students/{studentId}/dropClass")
    public String dropClassFromStudnet(@PathVariable("studentId") Long studentId, @RequestParam("classToDrop") Long classToDropId) {
    	Student student = studentService.findStudent(studentId);
    	student.getClasses().remove(classService.findSWClass(classToDropId));
    	studentService.saveStudent(student);
    	return "redirect:/students/" + studentId.toString();
    }
//    
//    @GetMapping("/students/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Student student = studentService.findStudent(id);
//        model.addAttribute("student", student);
//        return "edit.jsp";
//    }
//    
//    @PutMapping("/students/edit/{id}")
//    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("student") Student student, BindingResult result) {
//        if (result.hasErrors()) {
//            return "edit.jsp";
//        } else {
//            studentService.updateStudent(id, student);
//            return "redirect:/students";
//        }
//    }
//    
//    @DeleteMapping("/students/delete/{id}")
//    public String deleteStudent(@PathVariable("id") Long id) {
//        studentService.deleteStudent(id);
//        return "redirect:/students";
//    }
}

