package com.bridgelabs.workshop;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
	/*
	 * @desc:Main method to run the program
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	public static void main(String[] args) {
		LibraryImpl library = new LibraryImpl();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. ADD BOOK");
			System.out.println("2. REMOVE BOOK");
			System.out.println("3. FILTER BOOKS BY GENRE");
			System.out.println("4. CALCULATE AVERAGE PRICE OF BOOKS");
			System.out.println("5. FIND MOST EXPENSIVE BOOK");
			System.out.println("6. DISPLAY ALL THE BOOKS");
			System.out.println("7. FIND BOOK BY TITLE");
			System.out.println("8. FILTER BOOKS BY PRICE THRESHOLD");
			System.out.println("9. DISPLAY SORTED BOOKS");
			System.out.println("10. BOOKS PUBLISHED WITHIN A DATE RANGE");
			System.out.println("11. BOOKS BY A SPECIFIC AUTHOR");
			System.out.println("12.EXIT");

			System.out.println("Enter your choice :- ");
			int ch = scanner.nextInt();
			switch (ch) {
			case 1:
				Book book1 = new Book("A", "B", "Fiction", 100, LocalDate.of(2002, 12, 1));
				Book book2 = new Book("C", "D", "Fantasy", 200, LocalDate.of(2001, 11, 2));
				Book book3 = new Book("E", "F", "Fiction", 300, LocalDate.of(2000, 10, 4));
				library.addBook(book1);
				library.addBook(book2);
				library.addBook(book3);
				System.out.println();
				break;
			case 2:
				Book book11 = new Book("A", "B", "Fiction", 100, LocalDate.of(2002, 12, 1));
				library.removeBook(book11);
				System.out.println();
				break;
			case 3:
				library.filterBooksByGenre(LibraryImpl.books);
				System.out.println();
				break;

			case 4:
				library.averagePriceOfBooks(LibraryImpl.books);
				System.out.println();
				break;

			case 5:
				library.mostExpensiveBook(LibraryImpl.books);
				break;

			case 6:
				for (Book book : LibraryImpl.books) {
					System.out.println(book);
				}
				System.out.println();
				break;

			case 7:
				Optional<Book> title = library.findBookByTitle("A");
				System.out.println("filter books by title:- " + title);
				System.out.println();
				break;

			case 8:
				List<Book> cheapBooks = library.filterBooks(book -> book.getPrice() < 200);
				cheapBooks.forEach(System.out::println);
				System.out.println();
				break;

			case 9:
				System.out.println("Display books in sorted order");
				library.displaySortedBooks();
				System.out.println();
				break;

			case 10:
				System.out.println("Display books published in a certain range");
				library.findBookByPublicationDate(LocalDate.of(2001, 1, 1), LocalDate.of(2002, 1, 1));
				System.out.println();
				break;

			case 11:
				System.out.println("Books by a specific author:- ");
				library.findBooksByAuthorName("B");
				System.out.println();
				break;

			case 12:
				System.out.println("Exiting program. Goodbye!");
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please choose a valid option.\n");

			}

		}
	}

}
