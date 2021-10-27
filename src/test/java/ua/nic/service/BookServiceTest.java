package ua.nic.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.nic.config.AppConfig;
import ua.nic.entity.Book;

import java.time.LocalDateTime;

public class BookServiceTest {

	private static BaseService<Book> bookService;
	private Book testBook;
	private int num1,num2;
	@BeforeClass
	public static void init() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		bookService = (BaseService<Book>) applicationContext.getBean("bookService");

	}

	@Test
	public void testAllCrudOperation() {
		testBook = new Book();
		testBook.setCreatedDate(LocalDateTime.now());
		testBook.setName("LOTR");
		testBook.setIsbn(4578543);
		num1 = bookService.save(testBook);
		Assert.assertNotNull(num1);
		testBook.setCreatedDate(LocalDateTime.now());
		testBook.setName("LOTR");
		testBook.setIsbn(457854323);
		num2 = bookService.save(testBook);
		Assert.assertNotNull(num2);
		Assert.assertNotNull(bookService.get(1));
		Assert.assertEquals(2,bookService.getAll().size());
		testBook.setCreatedDate(LocalDateTime.now());
		testBook.setName("LOTR3");
		testBook.setIsbn(1324365768);
		bookService.update(num1,testBook);
		Assert.assertEquals(bookService.get(num1).getName(),"LOTR3");
		Assert.assertEquals(bookService.get(num1).getIsbn(),1324365768);
		bookService.delete(num1);
		bookService.delete(num2);
		Assert.assertNull(bookService.get(num1));
		Assert.assertNull(bookService.get(num2));
	}

}