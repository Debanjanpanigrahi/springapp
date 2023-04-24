package com.nagarro.authorAndBookSystem.repository;

import com.nagarro.authorAndBookSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE Book SET bookName = :bookName WHERE bookId = :bookId")
	void updateBookById(long bookId, String bookName);

}
