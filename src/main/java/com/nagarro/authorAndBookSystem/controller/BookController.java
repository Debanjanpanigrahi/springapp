package com.nagarro.authorAndBookSystem.controller;

import com.nagarro.authorAndBookSystem.model.Author;
import com.nagarro.authorAndBookSystem.model.Book;
import com.nagarro.authorAndBookSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/book")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		return new ResponseEntity<>(bookService.getBooks(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") long bookId) {
		return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
	}

	@PutMapping("/book/{id}")
	public void updateBook(@PathVariable("id") long bookId, @RequestBody Book book) {
		bookService.updateBook(bookId, book);
	}

	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable("id") long bookId) {
		bookService.deleteBookById(bookId);
		return "book deleted successfully";
	}

}
