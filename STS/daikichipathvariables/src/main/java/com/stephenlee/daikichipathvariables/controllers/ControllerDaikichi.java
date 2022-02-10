package com.stephenlee.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class ControllerDaikichi {
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String todayFortune() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrowFortune() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/travel/{location}")
	public String travelTo(@PathVariable("location") String location) {
		return "Congratulations! You will soon travel to " + location + "!";
	}
	
	@RequestMapping("/lotto/{number}")
	public String playLotto(@PathVariable("number") String number) {
		int numInt = Integer.parseInt(number);
		if (numInt % 2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers";
		}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
}
