package com.stephenlee.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephenlee.projectmanager.models.LoginUser;
import com.stephenlee.projectmanager.models.Project;
import com.stephenlee.projectmanager.models.User;
import com.stephenlee.projectmanager.services.ProjectService;
import com.stephenlee.projectmanager.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProjectService projectService;
    
    // login and registration page with forms for each function
    @GetMapping("/")
	public String loginRegister(Model model, HttpSession session) {
		if (session.getAttribute("uuid") != null) {
			return "redirect:/dashboard";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "loginReg.jsp";
	}

    // process the register form when user hits register button
	@PostMapping("/register")
	public String registerUser(Model model, @Valid @ModelAttribute("newUser") User newUser, BindingResult result,
			HttpSession session) {
		User user = userService.register(newUser, result);
		if (result.hasErrors() || user == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "loginReg.jsp";
		} else {
			session.setAttribute("uuid", user.getId());
			session.setAttribute("loggedin_name", user.getName());
			return "redirect:/dashboard";
		}
	}

	// process the login form when user hits login button
	@PostMapping("/login")
	public String loginUser(Model model, @Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result,
			HttpSession session) {
		User user = userService.login(newLogin, result);
		if (result.hasErrors() || user == null) {
			model.addAttribute("newUser", new User());
			return "loginReg.jsp";
		} else {
			session.setAttribute("uuid", user.getId());
			session.setAttribute("loggedin_name", user.getName());
			return "redirect:/dashboard";
		}
	}

	// dashboard, shows when user is logged in
	@GetMapping("/dashboard")
	public String dashBoard(HttpSession session, Model model) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		List<Project> projects = projectService.allProjects();
		User user = userService.findUser((Long) session.getAttribute("uuid"));
//		List<Project> projects = projectService.findProjectsWithoutParticipant(user);
		model.addAttribute("user",user);
		model.addAttribute("projects",projects);
		return "dashboard.jsp";
	}

	// logout logic, clears session
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

