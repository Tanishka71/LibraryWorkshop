package com.bridgelabs.workshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Author {
	private String name;
	private LocalDate birthDate;
	private List<Book> writtenBooks;

	public Author(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
		this.writtenBooks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public LocalDate getDate() {
		return birthDate;
	}

	public List<Book> getBooks() {
		return writtenBooks;
	}

	public int calculateAge() {
		Date current = new Date();
		int year = birthDate.getYear();
		int currentYear = current.getYear();
		return currentYear - year;

	}

}
