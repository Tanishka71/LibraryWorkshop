package com.bridgelabs.workshop;

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryImpl implements Library {
	static List<Book> books;
	Scanner scanner = new Scanner(System.in);

	public LibraryImpl() {
		LibraryImpl.books = new ArrayList<>();
	}



	/*
	 * @desc:Display books in library
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	@Override
	public void displayTotal() {
		System.out.println("Total number of books are: " + books.size());

	}

	/*
	 * @desc:display sorted books in library
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	public void displaySortedBooks() {
		Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
		books.forEach(System.out::println);
	}

	/*
	 * @desc:calculate total prices of books in library
	 * 
	 * @params:none
	 * 
	 * @return:int
	 */
	public int calculateTotalBookValue() {
		int total =books.stream().mapToInt(Book::getPrice)
				.sum();
		return total;
	}

	/*
	 * @desc:Find book by title in library
	 * 
	 * @params:String
	 * 
	 * @return:Book
	 */
	public Optional<Book> findBookByTitle(String title) {
		return books.stream().filter(book -> book.getTitle().equals(title)).findFirst();
	}

	/*
	 * @desc:Filter books by price threshold
	 * 
	 * @params:BookPredicate
	 * 
	 * @return:Book
	 */
	public List<Book> filterBooks(BookPredicate predicate) {
		return books.stream().filter(predicate::test).collect(Collectors.toList());
	}

	/*
	 * @desc:filter books by genre
	 * 
	 * @params:Book
	 * 
	 * @return:none
	 */
	public void filterBooksByGenre(List<Book> books) {
		System.out.println("Enter genre to filter:- ");
		String genre = scanner.nextLine();
		List<Book> filterByGenre = books.stream().filter(book -> book.getGenre().equals(genre))
				.collect(Collectors.toList());

		System.out.println("Books filtered by genre are:- ");
		filterByGenre.forEach(System.out::println);
	}

	/*
	 * @desc:Average price of books
	 * 
	 * @params:Book
	 * 
	 * @return:none
	 */
	public void averagePriceOfBooks(List<Book> books) {

		double average = books.stream().mapToInt(Book::getPrice).average().orElse(0);

		System.out.println("The average of all the book prices are :- " + average);

	}

	/*
	 * @desc:Find most expensive book in library
	 * 
	 * @params:Book
	 * 
	 * @return:none
	 */
	public void mostExpensiveBook(List<Book> books) {
		Optional<Book> mostExpensive = books.stream().max(Comparator.comparingInt(Book::getPrice));

		mostExpensive.ifPresent(book -> System.out.println("Most expensive book: " + mostExpensive));
	}

	/*
	 * @desc:Find book by publication date
	 * 
	 * @params:LocalDate
	 * 
	 * @return:none
	 */
	public void findBookByPublicationDate(ChronoLocalDate start, ChronoLocalDate end) {
		books.stream()
				.filter(book -> book.getPublicationDate().isAfter(start) && book.getPublicationDate().isBefore(end))
				.forEach(System.out::println);
	}

	/*
	 * @desc:find books by author name
	 * 
	 * @params:String
	 * 
	 * @return:none
	 */
	public void findBooksByAuthorName(String authorName) {
		books.stream().filter(book -> book.getAuthor().equals(authorName)).forEach(System.out::println);
	}
}
