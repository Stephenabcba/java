package com.stephenlee.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephenlee.dojoandninjas.models.Dojo;
import com.stephenlee.dojoandninjas.models.Ninja;
import com.stephenlee.dojoandninjas.services.DojoService;
import com.stephenlee.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {
    @Autowired
    private NinjaService ninjaService;
    
    @Autowired
    private DojoService dojoService;
    
    @GetMapping("/ninjas/new")
    public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
    	List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newNinja.jsp";
    }
  
    @PostMapping("/ninjas/new")
    public String create(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
        	List<Dojo> dojos = dojoService.allDojos();
            model.addAttribute("dojos", dojos);
            return "newNinja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/dojos";
        }
    }
}

