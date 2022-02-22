package com.stephenlee.studentrosterii.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.stephenlee.studentrosterii.models.SWClass;
import com.stephenlee.studentrosterii.services.SWClassService;

@Controller
public class SWClassController {
    @Autowired
    private SWClassService swClassService;
    
    @GetMapping("/classes/new")
    public String swClasses(@ModelAttribute("swClass") SWClass swClass) {
        return "addClass.jsp";
    }
    
    @PostMapping("/classes/new")
    public String create(@Valid @ModelAttribute("swClass") SWClass swClass, BindingResult result) {
        if (result.hasErrors()) {
            return "addClass.jsp";
        } else {
            swClassService.createSWClass(swClass);
            return "redirect:/classes/new";
        }
    }
    
    @GetMapping("/classes/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        SWClass swClass = swClassService.findSWClass(id);
        if (swClass == null) {
        	return "redirect:/classes/new";
        }
        model.addAttribute("swClass", swClass);
        return "showClass.jsp";
    }
//    
//    @GetMapping("/swClasses/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        SWClass swClass = swClassService.findSWClass(id);
//        model.addAttribute("swClass", swClass);
//        return "edit.jsp";
//    }
//    
//    @PutMapping("/swClasses/edit/{id}")
//    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("swClass") SWClass swClass, BindingResult result) {
//        if (result.hasErrors()) {
//            return "edit.jsp";
//        } else {
//            swClassService.updateSWClass(id, swClass);
//            return "redirect:/swClasses";
//        }
//    }
//    
//    @DeleteMapping("/swClasses/delete/{id}")
//    public String deleteSWClass(@PathVariable("id") Long id) {
//        swClassService.deleteSWClass(id);
//        return "redirect:/swClasses";
//    }
}

