package com.stephenlee.bookbroker.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephenlee.bookbroker.models.LoginUser;
import com.stephenlee.bookbroker.models.User;
import com.stephenlee.bookbroker.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
	public String loginRegister(Model model, HttpSession session) {
		if (session.getAttribute("uuid") != null) {
			return "redirect:/books";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}

	@PostMapping("/register")
	public String registerUser(Model model, @Valid @ModelAttribute("newUser") User newUser, BindingResult result,
			HttpSession session) {
		User user = userService.register(newUser, result);
		if (result.hasErrors() || user == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		} else {
			session.setAttribute("uuid", user.getId());
			session.setAttribute("loggedin_name", user.getName());
			return "redirect:/books";
		}
	}

	@PostMapping("/login")
	public String loginUser(Model model, @Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result,
			HttpSession session) {
		User user = userService.login(newLogin, result);
		if (result.hasErrors() || user == null) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		} else {
			session.setAttribute("uuid", user.getId());
			session.setAttribute("loggedin_name", user.getName());
			return "redirect:/books";
		}
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
//    @GetMapping("/users")
//    public String users(Model model, @ModelAttribute("user") User user) {
//        List<User> users = userService.allUsers();
//        model.addAttribute("users", users);
//        return "index.jsp";
//    }
//    
//    @PostMapping("/users")
//    public String create(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {
//        if (result.hasErrors()) {
//            List<User> users = userService.allUsers();
//            model.addAttribute("users", users);
//            return "index.jsp";
//        } else {
//            userService.createUser(user);
//            return "redirect:/users";
//        }
//    }
//    
//    @GetMapping("/users/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        User user = userService.findUser(id);
//        model.addAttribute("user", user);
//        return "show.jsp";
//    }
//    
//    @GetMapping("/users/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        User user = userService.findUser(id);
//        model.addAttribute("user", user);
//        return "edit.jsp";
//    }
//    
//    @PutMapping("/users/edit/{id}")
//    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "edit.jsp";
//        } else {
//            userService.updateUser(id, user);
//            return "redirect:/users";
//        }
//    }
//    
//    @DeleteMapping("/users/delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
}

