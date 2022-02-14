package com.stephenlee.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gold")
public class GoldController {
	@GetMapping("")
	public String show(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}
	
	@PostMapping("/make_gold")
	public String makeGold(@RequestParam(value="income_type") String income_type, HttpSession session) {
		Random rand = new Random();
		int gold = 0;
		switch (income_type) {
		case "farm":
			gold = rand.nextInt(11) + 10;
			break;
		case "cave":
			gold = rand.nextInt(6) + 5;
			break;
		case "house":
			gold = rand.nextInt(4) + 2;
			break;
		case "casino":
			gold = rand.nextInt(101) - 50;
			break;
		case "spa":
			gold = -(rand.nextInt(16) + 5);
			break;
		
		}
		String message = String.format("You entered a %s and %s %d gold.%s", income_type, gold>=0?"earned":"lost",Math.abs(gold), gold>=0?"":".Ouch.");
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM d yyyy HH:mm aaa");
		message += " (" + sdf.format(new Date()) + ")\n";
		message = String.format("<p class='text-%s'>%s</p>", gold>=0?"success":"danger",message);
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("message") == null) {
			session.setAttribute("message", "");
		}
		session.setAttribute("message", message + session.getAttribute("message"));
		session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
				
		return "redirect:/gold";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/gold";
	}
}
