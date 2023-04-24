package com.nagarro.authorAndBookSystem.controller;

import com.nagarro.authorAndBookSystem.model.Author;
import com.nagarro.authorAndBookSystem.repository.AuthorRepository;
import com.nagarro.authorAndBookSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@PostMapping("/author")

	public void saveBook(@RequestBody Author author) {
		authorService.saveAuthor(author);
	}

	@GetMapping("/authors")
	public List<Author> getAuthors() {
		LocalDate myObj = LocalDate.now();
		System.out.println(myObj.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
		return authorService.getAuthors();
	}

	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable("id") long authorId) {
		return new ResponseEntity<>(authorService.getAuthorById(authorId), HttpStatus.OK);
	}

	@PutMapping("/author/{id}")
	public void updateAuthor(@PathVariable("id") long authorId, @RequestBody Author author) {
		authorService.updateAuthorById(authorId, author);
	}

	@DeleteMapping("/author/{id}")
	public String deleteBook(@PathVariable("id") long authorId) {
		authorService.deleteAuthorById(authorId);
		return "book deleted successfully";
	}

}
