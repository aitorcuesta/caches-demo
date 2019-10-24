package es.aitorcuesta.caches.demo.dao;

import es.aitorcuesta.caches.demo.model.Book;
/**
 * 
 * @author aitorcuesta
 *
 */
public interface BookDao {
	
	/**
	 * Adds a {@link Book} to the database
	 * @param book The {@link Book} to be added
	 */
	void addBook(Book book);
	
	/**
	 * Gets a {@link Book} from the database using the ISBN
	 * @param isbn The ISBN
	 * @return The {@link Book} that matches with de ISBN, otherwise null is returned
	 */
    Book getBook(String isbn);
    
    /**
     * Updates a {@link Book} into the databse
     * @param isbn The ISBN
     * @param book The {@link Book} to be updated
     * @return The updated {@link Book}
     */
    Book updateBook(String isbn, Book book);
    
    /**
     * Deletes a {@link Book} from the database
     * @param isbn The ISBN
     */
    void deleteBook(String isbn);
    
    /**
     * Writes the database content
     */
    void dumpDatabase();

}
