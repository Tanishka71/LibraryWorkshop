package com.bridgelabs.workshop;

public interface Library {
	/*
	 * @desc:Add book in library
	 * 
	 * @params:Book
	 * 
	 * @return:none
	 */
	default void addBook(Book book) {
		System.out.println("Book added.");
		LibraryImpl.books.add(book);

	}

	/*
	 * @desc:Remove book from library
	 * 
	 * @params:Book
	 * 
	 * @return:none
	 */
	default void removeBook(Book book) {
		LibraryImpl.books.remove(book);
		System.out.println("Book removed .");;

	}

	void displayTotal();

}
