package com.bridgelabs.workshop;

@FunctionalInterface
public interface BookPredicate {
	boolean test(Book book);
}
