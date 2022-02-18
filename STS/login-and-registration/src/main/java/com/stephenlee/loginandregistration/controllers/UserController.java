package com.stephenlee.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephenlee.loginandregistration.models.LoginUser;
import com.stephenlee.loginandregistration.models.User;
import com.stephenlee.loginandregistration.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String loginRegister(Model model, HttpSession session) {
    	if (session.getAttribute("uuid") != null) {
    		return "redirect:/dashboard";
    	}
    	model.addAttribute("newUser", new User());
    	model.addAttribute("newLogin", new LoginUser());
    	return "login.jsp";
    }
    
    @PostMapping("/register")
    public String registerUser(Model model, @Valid @ModelAttribute("newUser") User newUser,
    		BindingResult result, HttpSession session) {
    	User user = userService.register(newUser, result);
    	if (user == null) {
//    		model.addAttribute("newUser", new User());
        	model.addAttribute("newLogin", new LoginUser());
        	return "login.jsp";
    	} else {
    		session.setAttribute("uuid", user.getId());
    		session.setAttribute("loggedin_name", user.getName());
    		return "redirect:/dashboard";
    	}
    }
    
    @PostMapping("/login")
    public String loginUser(Model model, @Valid @ModelAttribute("newLogin") LoginUser newLogin,
    		BindingResult result, HttpSession session) {
    	User user = userService.login(newLogin, result);
    	if (user == null) {
    		model.addAttribute("newUser", new User());
//        	model.addAttribute("newLogin", new LoginUser());
        	return "login.jsp";
    	} else {
    		session.setAttribute("uuid", user.getId());
    		session.setAttribute("loggedin_name", user.getName());
    		return "redirect:/dashboard";
    	}
    }
    
    @GetMapping("/dashboard")
    public String dashBoard(HttpSession session) {
    	if (session.getAttribute("uuid") == null) {
    		return "redirect:/";
    	}
    	return "dashboard.jsp";
    }
    
    @PostMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}

