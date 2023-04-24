package com.nagarro.authorAndBookSystem.service.impl;

import com.nagarro.authorAndBookSystem.model.Author;
import com.nagarro.authorAndBookSystem.repository.AuthorRepository;
import com.nagarro.authorAndBookSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Author getAuthorById(long authorId) {
		return authorRepository.findById(authorId).orElse(null);
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public void updateAuthorById(long authorId, Author author) {
		authorRepository.updateAuthorById(authorId, author.getAuthorName());
	}

	@Override
	public void deleteAuthorById(long authorId) {
		authorRepository.deleteById(authorId);
	}
}
