package com.bridgelabs.workshop;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {

	private Book book;
	private LocalDate date;
	private String type;

	public Transaction(Book book, LocalDate date, String type) {
		this.book = book;
		this.date = date;
		this.type = type;
	}

	public Book getBook() {
		return book;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

}
