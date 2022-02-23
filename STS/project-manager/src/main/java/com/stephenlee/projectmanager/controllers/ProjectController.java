package com.stephenlee.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.stephenlee.projectmanager.models.Project;
import com.stephenlee.projectmanager.models.Task;
import com.stephenlee.projectmanager.models.User;
import com.stephenlee.projectmanager.services.ProjectService;
import com.stephenlee.projectmanager.services.TaskService;
import com.stephenlee.projectmanager.services.UserService;

@Controller
public class ProjectController {
	// Add all required services
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TaskService taskService;
    
    // Creates the view for form to create a new project
    @GetMapping("/projects/new")
    public String projects(@ModelAttribute("project") Project project, HttpSession session) {
    	if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
        return "newProject.jsp";
    }
    
    // Process the project creation form after submission
    @PostMapping("/projects/new")
    public String create(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "newProject.jsp";
        } else {
        	project.setCreator(userService.findUser((Long) session.getAttribute("uuid")));
            projectService.createProject(project);
            return "redirect:/dashboard";
        }
    }
    
    // Shows the specific project
    @GetMapping("/projects/{id}")
    public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
        Project project = projectService.findProject(id);
        if (project==null) {
        	return "redirect:/dashboard";
        }
        model.addAttribute("project", project);
        return "showProject.jsp";
    }
    
    // generates view for project editing form
    @GetMapping("/projects/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
        Project project = projectService.findProject(id);
        if (project==null) {
        	return "redirect:/dashboard";
        }
        model.addAttribute("project", project);
        return "editProject.jsp";
    }
    
    // processes and validates the submitted project editing form
    @PutMapping("/projects/{id}/edit")
    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("project") Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "editProject.jsp";
        } else {
            projectService.updateProject(id,project);
            return "redirect:/dashboard";
        }
    }
    
    // add the logged in user to the project specified 
    @PutMapping("/projects/{id}/joinTeam")
    public String joinTeam(@PathVariable("id") Long id, HttpSession session) {
    	User user = userService.findUser((Long) session.getAttribute("uuid"));
    	user.getParticipatingProjects().add(projectService.findProject(id));
    	userService.saveUser(user);
    	return "redirect:/dashboard";
    }
    
    
    // remove the logged in user from the project specified
    @PutMapping("/projects/{id}/leaveTeam")
    public String leaveTeam(@PathVariable("id") Long id, HttpSession session) {
    	User user = userService.findUser((Long) session.getAttribute("uuid"));
    	user.getParticipatingProjects().remove(projectService.findProject(id));
    	userService.saveUser(user);
    	return "redirect:/dashboard";
    }
    
    // shows the tasks related to given project, contains a form to add a task
    @GetMapping("/projects/{id}/tasks")
    public String showTask(@PathVariable("id") Long id, Model model, @ModelAttribute("task") Task task, HttpSession session) {
    	if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
        Project project = projectService.findProject(id);
        if (project == null) {
        	return "redirect:/dashboard";
        }
        model.addAttribute("project", project);
        return "showTask.jsp";
    }
    
    // adds the task with content submitted from form. logged in user is the poster, and task is added to project with specified ID in path
    @PostMapping("/projects/{projectId}/tasks")
    public String addTask(@PathVariable("projectId") Long projectId, Model model, @Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session) {
    	Project project = projectService.findProject(projectId);
    	if (result.hasErrors()) {
            model.addAttribute("project", project);
            return "showTask.jsp";
    	}
    	task.setUser(userService.findUser((Long) session.getAttribute("uuid")));
    	task.setProject(project);
    	taskService.createTask(task);
    	return "redirect:/projects/"+ projectId.toString() +"/tasks";
    }
    
    // route to delete user
    @DeleteMapping("/projects/{id}/delete")
    public String deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return "redirect:/dashboard";
    }
}

