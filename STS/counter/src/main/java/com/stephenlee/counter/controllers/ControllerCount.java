package com.stephenlee.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerCount {
	@GetMapping("/")
	public String home(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		}
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
}
