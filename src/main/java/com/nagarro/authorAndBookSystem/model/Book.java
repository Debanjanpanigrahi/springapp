package com.nagarro.authorAndBookSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	private String bookCode;
	private String bookName;
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Author author;

	private String createdOn;

	public Book() {
	}

	public Book(long bookId, String bookCode, String bookName, Author author) {
		this.bookId = bookId;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
