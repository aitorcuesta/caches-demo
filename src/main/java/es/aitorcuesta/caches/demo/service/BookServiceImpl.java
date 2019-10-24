package es.aitorcuesta.caches.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.aitorcuesta.caches.demo.dao.BookDao;
import es.aitorcuesta.caches.demo.model.Book;

/**
 * 
 * @author aitorcuesta
 *
 */
@Component("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public void addBook(String isbn, String title, String author) {
		Book book = new Book(isbn, title, author);
		bookDao.addBook(book);
	}

	@Override
	public Book getBook(String isbn) {
		return bookDao.getBook(isbn);
	}

	@Override
	public void updateBook(String isbn, String title, String author) {
		Book book = new Book(isbn, title, author);
		bookDao.updateBook(isbn, book);
	}

	@Override
	public void deleteBook(String isbn) {
		bookDao.deleteBook(isbn);
	}

	@Override
	public void printAllBooks() {
		bookDao.dumpDatabase();
	}

}
