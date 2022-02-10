package com.stephenlee.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHello {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="last_name", required=false) String last_name, @RequestParam(value="times", required=false) String times) {
		if (name == null) {
			return "Hello Human";
		}
		if (last_name == null) {
			if (times == null) {				
				return "Hello " + name;
			} else {
				String baseHello = "Hello " + name;
				String returnString = "";
				for (int i = 0; i < Integer.parseInt(times); i++) {
					returnString += baseHello;
					if (i != Integer.parseInt(times) - 1) {						
						returnString += " ";
					}
				}
				return returnString;
			}
		}
		return "Hello " + name + " " + last_name;
		
	}
}
