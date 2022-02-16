package com.stephenlee.languages.controllers;

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

import com.stephenlee.languages.models.Language;
import com.stephenlee.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/languages")
	public String index(Model model,@ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String addLanguage(Model model,@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(id, language);
			return "redirect:/languages";
		}
	}
}
