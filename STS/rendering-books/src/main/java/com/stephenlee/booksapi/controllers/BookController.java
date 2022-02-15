package com.stephenlee.booksapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stephenlee.booksapi.models.Book;
import com.stephenlee.booksapi.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/{bookId}")
	public String showBook(Model model, @PathVariable("bookId") Long bookID) {
		Book book = bookservice.findBook(bookID);
		model.addAttribute("book", book);
		return "show.jsp";
	}
}
