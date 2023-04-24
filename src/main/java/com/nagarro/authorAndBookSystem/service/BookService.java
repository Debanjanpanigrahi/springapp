package com.nagarro.authorAndBookSystem.service;

import com.nagarro.authorAndBookSystem.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

	Book getBookById(long bookId);

	List<Book> getBooks();

	Book saveBook(Book book);

	void updateBook(long bookId, Book book);

	void deleteBookById(long bookId);
}
