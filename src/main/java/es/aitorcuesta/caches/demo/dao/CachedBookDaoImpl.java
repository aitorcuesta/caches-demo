package es.aitorcuesta.caches.demo.dao;

import java.util.HashMap;
import java.util.Map;

import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheResult;
import javax.cache.annotation.CacheValue;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import es.aitorcuesta.caches.demo.model.Book;

@Component("cachedBookDao")
public class CachedBookDaoImpl implements BookDao {

	private static final Logger logger = Logger.getLogger(CachedBookDaoImpl.class);
	  
    private static final Map<String, Book> bookDatabase = new HashMap<>();
  
    @Override
    public void addBook(Book book) {
        if (null != book) {
            bookDatabase.put(book.getIsbn(), book);
        }
    }
  
    @Override 
    @CacheResult(cacheName = "books")
    public Book getBook(String isbn) {
        try {
            // Slow database :P
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isbn != null ? bookDatabase.get(isbn) : null;
    }
  
    @Override 
    @CachePut(cacheName = "books")
    public Book updateBook(String isbn, @CacheValue Book book) {
        Book retValue = null;
        if (null != book && null != isbn) {
            bookDatabase.put(isbn, book);
            retValue = book;
        }
        return retValue;
    }
  
    @Override 
    @CacheRemove(cacheName = "books")
    public void deleteBook(String isbn) {
        if (null != isbn && bookDatabase.containsKey(isbn)) {
            bookDatabase.remove(isbn);
        }
    }
  
    @Override
    public void dumpDatabase() {
        logger.info("Dumping database: " + bookDatabase.toString());
    }
}