package com.bridgelabs.workshop;

import java.time.LocalDate;
import java.util.Date;

public class Book {
	private String title;
	private String author;
	private String genre;
	private int price;
	private LocalDate publicationDate;

	public Book(String title, String author, String genre, int price, LocalDate localDate) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.publicationDate = localDate;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public int getPrice() {
		return price;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	@Override
	public String toString() {
		return "Title: " + title + " Author: " + author + " Genre: " + genre + " Price: " + price
				+ " Publication Date: " + publicationDate;
	}
}
