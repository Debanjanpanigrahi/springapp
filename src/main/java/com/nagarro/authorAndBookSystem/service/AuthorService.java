package com.nagarro.authorAndBookSystem.service;

import com.nagarro.authorAndBookSystem.model.Author;

import java.util.List;

public interface AuthorService {

	Author getAuthorById(long authorId);

	List<Author> getAuthors();

	Author saveAuthor(Author author);

	void updateAuthorById(long authorId, Author author);

	void deleteAuthorById(long authorId);

}
