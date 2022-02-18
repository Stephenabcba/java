package com.stephenlee.bookbroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.bookbroker.models.Book;
import com.stephenlee.bookbroker.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book e) {
        return bookRepo.save(e);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Long id, Book newBook) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setThought(newBook.getThought());
            return bookRepo.save(book);
        } else {
            return null;
        }
    }
    
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
    
    public List<Book> findAllUnborrowedBooks() {
    	return bookRepo.findByBorrowerIsNull();
    }
    
    public Book saveBook(Book e) {
        return bookRepo.save(e);
    }
    
    public List<Book> findAllBorrowedByUserId(Long id) {
    	return bookRepo.findByBorrowerId(id);
    }
}

