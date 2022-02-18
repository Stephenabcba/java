package com.stephenlee.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.stephenlee.bookclub.models.Book;
import com.stephenlee.bookclub.models.User;
import com.stephenlee.bookclub.services.BookService;
import com.stephenlee.bookclub.services.UserService;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    
	@GetMapping("/books")
	public String dashBoard(HttpSession session, Model model) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "dashboard.jsp";
	}
    
    @GetMapping("/books/new")
    public String newBook(HttpSession session, Model model, @ModelAttribute("book") Book book) {
    	if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
        return "newBook.jsp";
    }
    
    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "newBook.jsp";
        } else {
        	User poster = userService.findUser((Long) session.getAttribute("uuid"));
        	book.setPoster(poster);
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    @GetMapping("/books/{id}")
    public String show(HttpSession session, @PathVariable("id") Long id, Model model) {
    	if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
        Book book = bookService.findBook(id);
        if (book == null) {
        	return "redirect:/books";
        }
        model.addAttribute("book", book);
        return "showBook.jsp";
    }
    
    @GetMapping("/books/{id}/edit")
    public String edit(HttpSession session, @PathVariable("id") Long id, Model model) {
    	if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
    	Book book = bookService.findBook(id);
    	if (book == null) {
        	return "redirect:/books";
        }
    	if (!book.getPoster().getId().equals((Long) session.getAttribute("uuid")) ) {
    		return "redirect:/books";
    	}
        model.addAttribute("book", book);
        return "editBook.jsp";
    }
    
    @PutMapping("/books/{id}/edit")
    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
        	Book curBook = bookService.findBook(id);
        	if (curBook == null) {
            	return "redirect:/books";
        	}
            return "editBook.jsp";
        } else {
            bookService.updateBook(id, book);
            return "redirect:/books";
        }
    }
//    
//    @DeleteMapping("/books/delete/{id}")
//    public String deleteBook(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//        return "redirect:/books";
//    }
}

