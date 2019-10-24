package es.aitorcuesta.caches.demo;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import es.aitorcuesta.caches.demo.model.Book;
import es.aitorcuesta.caches.demo.service.BookService;

@Configuration
@EnableCaching
@ComponentScan
public class CachesDemo {

	private static final Logger logger = Logger.getLogger(CachesDemo.class);

	public static void main(String[] args) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(CachesDemo.class);

		logger.info("Invoking simple service");
		invokeService((BookService) appCtx.getBean("simpleBookService"));
		logger.info("Ending invoking simple service");

	}
	
	// Using with simple cache memory
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

	private static void invokeService(BookService bookService) {
		logger.info("Adding books...");
		bookService.addBook("1", "A tale of two cities", "Charles Dickens");
		bookService.addBook("2", "Le petit Prince", "Antoine de Saint-Exupery");
		bookService.addBook("3", "Lolita", "Vladimir Nabokov");
		logger.info("Getting all books...");
		long startTime = System.nanoTime();
		Book book = bookService.getBook("1");
		logger.info(book != null ? book.toString() : "No book!!");
		book = bookService.getBook("2");
		logger.info(book != null ? book.toString() : "No book!!");
		book = bookService.getBook("3");
		logger.info(book != null ? book.toString() : "No book!!");
		logger.info("Getting all books took --> "
				+ TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS));
		logger.info("Getting again all books...");
		startTime = System.nanoTime();
		book = bookService.getBook("1");
		logger.info(book != null ? book.toString() : "No book!!");
		book = bookService.getBook("2");
		logger.info(book != null ? book.toString() : "No book!!");
		book = bookService.getBook("3");
		logger.info(book != null ? book.toString() : "No book!!");
		logger.info("Getting all books took --> "
				+ TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS));
		logger.info("Updating a book");
		bookService.updateBook("3", "LOLITA", "Vladimir Nabokov");
		bookService.printAllBooks();
		book = bookService.getBook("1");
		logger.info(book != null ? book.toString() : "No book!!");
		book = bookService.getBook("2");
		logger.info(book != null ? book.toString() : "No book!!");
		book = bookService.getBook("3");
		logger.info(book != null ? book.toString() : "No book!!");
		logger.info("Deleting a book");
		bookService.deleteBook("3");
		bookService.printAllBooks();
		book = bookService.getBook("1");
		logger.info(book != null ? book.toString() : "No book!!");
		book = bookService.getBook("2");
		logger.info(book != null ? book.toString() : "No book!!");
		book = bookService.getBook("3");
		logger.info(book != null ? book.toString() : "No book!!");
	}

}
