package es.aitorcuesta.caches.demo.service;

import es.aitorcuesta.caches.demo.model.Book;

/**
 * 
 * @author aitorcuesta
 *
 */
public interface BookService {

	/**
	 * Creates and adds a new {@link Book}
	 * 
	 * @param isbn   The ISBN
	 * @param title  The title
	 * @param author The author
	 */
	void addBook(String isbn, String title, String author);

	/**
	 * Gets a stored {@link Book} using the ISBN
	 * 
	 * @param isbn The ISBN
	 * @return The {@link Book}
	 */
	Book getBook(String isbn);

	/**
	 * Updates a stored {@link Book}
	 * 
	 * @param isbn   The ISBN
	 * @param title  The title
	 * @param author The author
	 */
	void updateBook(String isbn, String title, String author);

	/**
	 * Deletes a stored {@link Book}
	 * 
	 * @param isbn The ISBN
	 */
	void deleteBook(String isbn);

	/**
	 * Prints all stored  {@link Book}
	 */
	void printAllBooks();

}
