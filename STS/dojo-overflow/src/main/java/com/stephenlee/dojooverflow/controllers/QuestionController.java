package com.stephenlee.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephenlee.dojooverflow.models.Answer;
import com.stephenlee.dojooverflow.models.Question;
import com.stephenlee.dojooverflow.services.AnswerService;
import com.stephenlee.dojooverflow.services.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;

	@GetMapping("/questions")
	public String questionsDashboard(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "dashboard.jsp";
	}

	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}

	@PostMapping("/questions/new")
	public String create(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		if (result.hasErrors()) {
			return "newQuestion.jsp";
		} else {
			questionService.createQuestion(question);
			return "redirect:/questions";
		}
	}

	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model) {
		Question question = questionService.findQuestion(id);
		Answer answer = new Answer();
		model.addAttribute("answer", answer);
		model.addAttribute("question", question);
		return "showQuestion.jsp";
	}

	@PostMapping("/questions/{q_id}/addAnswer") // "id" will get magically bound to the model attribute answer
	public String addAnswer(@PathVariable("q_id") Long id, Model model, @Valid @ModelAttribute("answer") Answer answer,
			BindingResult result) {
		if (result.hasErrors()) {
			Question question = questionService.findQuestion(id);
			model.addAttribute("question", question);
			return "showQuestion.jsp";
		}
		Question question = questionService.findQuestion(id);
		answer.setQuestion(question);
		answerService.createAnswer(answer);
		return "redirect:/questions/" + id.toString();
	}
//    
//    @GetMapping("/questions/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Question question = questionService.findQuestion(id);
//        model.addAttribute("question", question);
//        return "edit.jsp";
//    }
//    
//    @PutMapping("/questions/edit/{id}")
//    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("question") Question question, BindingResult result) {
//        if (result.hasErrors()) {
//            return "edit.jsp";
//        } else {
//            questionService.updateQuestion(id, question);
//            return "redirect:/questions";
//        }
//    }
//    
//    @DeleteMapping("/questions/delete/{id}")
//    public String deleteQuestion(@PathVariable("id") Long id) {
//        questionService.deleteQuestion(id);
//        return "redirect:/questions";
//    }
}
