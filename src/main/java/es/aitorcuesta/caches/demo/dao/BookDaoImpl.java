package es.aitorcuesta.caches.demo.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import es.aitorcuesta.caches.demo.model.Book;

/**
 * 
 * @author aitorcuesta
 *
 */
@Component("simpleBookDao")
public class BookDaoImpl implements BookDao {

	private static final Logger logger = Logger.getLogger(BookDaoImpl.class);
	private static final Map<String, Book> bookDatabase = new HashMap<>();

	@Override
	public void addBook(Book book) {
		if (null != book) {
			bookDatabase.put(book.getIsbn(), book);
		}
	}

	@Override
	public Book getBook(String isbn) {
		try {
			// Slow database :P
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
		return isbn != null ? bookDatabase.get(isbn) : null;
	}

	@Override
	public Book updateBook(String isbn, Book book) {
		return (null != book && null != isbn) ? bookDatabase.put(isbn, book) : null;
	}

	@Override
	public void deleteBook(String isbn) {
		if (null != isbn) {
			bookDatabase.remove(isbn);
		}
	}

	@Override
	public void dumpDatabase() {
		logger.info("Dumping database: " + bookDatabase.toString());
	}

}
