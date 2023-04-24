package com.nagarro.authorAndBookSystem.repository;

import com.nagarro.authorAndBookSystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE Author SET authorName = :authorName WHERE authorId = :authorId")
	void updateAuthorById(long authorId, String authorName);
}
