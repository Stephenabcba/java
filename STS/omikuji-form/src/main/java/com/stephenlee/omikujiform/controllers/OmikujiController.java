package com.stephenlee.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	@GetMapping("")
	public String makeOmikuji() {
		return "omikuji_form.jsp";
	}
	
	@GetMapping("/show")
	public String showOmikuji() {
		return "show.jsp";
	}
	
	@PostMapping("/submit")
	public String submitOmikuji(HttpSession session,
			@RequestParam(value="pick_number") Integer pick_number,
			@RequestParam(value="city_name") String city_name,
			@RequestParam(value="person_name") String person_name,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="living_thing") String living_thing,
			@RequestParam(value="something_nice") String something_nice
	) {
		session.setAttribute("pick_number", pick_number);
		session.setAttribute("city_name", city_name);
		session.setAttribute("person_name", person_name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living_thing", living_thing);
		session.setAttribute("something_nice", something_nice);
		return "redirect:/omikuji/show";
	}
}
