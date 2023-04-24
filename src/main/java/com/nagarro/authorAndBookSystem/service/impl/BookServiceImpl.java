package com.nagarro.authorAndBookSystem.service.impl;

import com.nagarro.authorAndBookSystem.model.Book;
import com.nagarro.authorAndBookSystem.repository.BookRepository;
import com.nagarro.authorAndBookSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book getBookById(long bookId) {
		return bookRepository.findById(bookId).orElse(null);
	}

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void updateBook(long bookId, Book book) {
		bookRepository.updateBookById(bookId, book.getBookName());
	}

	@Override
	public void deleteBookById(long bookId) {
		bookRepository.deleteById(bookId);
	}
}
