package com.stephenlee.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stephenlee.studentroster.models.Dorm;
import com.stephenlee.studentroster.models.Student;
import com.stephenlee.studentroster.services.DormService;
import com.stephenlee.studentroster.services.StudentService;

@Controller
public class DormController {
    @Autowired
    private DormService dormService;
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/dorms")
    public String dorms(Model model) {
        List<Dorm> dorms = dormService.allDorms();
        model.addAttribute("dorms", dorms);
        return "index.jsp";
    }
    
    @GetMapping("/dorms/new")
    public String newDorms(@ModelAttribute("dorm") Dorm dorm) {
        return "createDorm.jsp";
    }
    
    @PostMapping("/dorms/new")
    public String create(Model model, @Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
        if (result.hasErrors()) {
            List<Dorm> dorms = dormService.allDorms();
            model.addAttribute("dorms", dorms);
            return "createDorm.jsp";
        } else {
            dormService.createDorm(dorm);
            return "redirect:/dorms";
        }
    }
    
    @GetMapping("/dorms/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Dorm dorm = dormService.findDorm(id);
        model.addAttribute("dorm", dorm);
        List<Student> dormlessStudents = studentService.allDormlessStudents();
        model.addAttribute("dormlessStudents", dormlessStudents);
        return "show.jsp";
    }
    
    @PostMapping("/dorms/{id}/add")
    public String addStudentToDorm(@PathVariable("id") Long id,@RequestParam("newStudentId") Long newStudentId) {
    	if (newStudentId != null) {    		
    		Dorm dorm = dormService.findDorm(id);
    		Student student = studentService.findStudent(newStudentId);
    		student.setDorm(dorm);
    		studentService.updateStudent(newStudentId, student);
    	}
    	return "redirect:/dorms/" + id.toString();
    }
    
    @DeleteMapping("/dorms/{id}/removeStudent")
    public String removeStudentFromDorm(@PathVariable("id") Long id, @RequestParam("studentId") Long studentId) {
    	Student student = studentService.findStudent(studentId);
    	student.setDorm(null);
    	studentService.updateStudent(studentId, student);
    	return "redirect:/dorms/" + id.toString();
    }
}

