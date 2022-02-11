package com.stephenlee.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerRoutes {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE', the' d 'of' MMMM', 'y");
		String date = sdf.format(d);
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		String time = sdf.format(d);
		model.addAttribute("time", time);
		return "time.jsp";
	}
	
	
}
