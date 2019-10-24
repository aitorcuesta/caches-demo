package es.aitorcuesta.caches.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.aitorcuesta.caches.demo.dao.BookDao;
import es.aitorcuesta.caches.demo.model.Book;

/**
 * 
 * @author aitorcuesta
 *
 */
@Component("simpleBookService")
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("cachedBookDao")
	private BookDao simpleBookDao;

	@Override
	public void addBook(String isbn, String title, String author) {
		Book book = new Book(isbn, title, author);
		simpleBookDao.addBook(book);
	}

	@Override
	public Book getBook(String isbn) {
		return simpleBookDao.getBook(isbn);
	}

	@Override
	public void updateBook(String isbn, String title, String author) {
		Book book = new Book(isbn, title, author);
		simpleBookDao.updateBook(isbn, book);
	}

	@Override
	public void deleteBook(String isbn) {
		simpleBookDao.deleteBook(isbn);
	}

	@Override
	public void printAllBooks() {
		simpleBookDao.dumpDatabase();
	}

}
