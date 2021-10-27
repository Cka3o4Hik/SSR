package ua.nic.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.nic.config.AppConfig;
import ua.nic.entity.Author;

import java.time.LocalDateTime;


public class AuthorServiceTest {

	private static BaseService<Author> authorService;
	private Author testAuthor;
	private int num1,num2;

	@BeforeClass
	public static void init() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		authorService = (BaseService<Author>) applicationContext.getBean("authorService");
	}

	@Test
	public void testAllCrudOperation() {
		testAuthor = new Author();
		testAuthor.setBirth(LocalDateTime.now());
		testAuthor.setCreatedDate(LocalDateTime.now());
		testAuthor.setEmail("tytmavbytymail");
		testAuthor.setFirstName("first");
		testAuthor.setLastName("second");
		num1 = authorService.save(testAuthor);
		Assert.assertNotNull(num1);
		testAuthor.setBirth(LocalDateTime.now());
		testAuthor.setCreatedDate(LocalDateTime.now());
		testAuthor.setEmail("tytmavbytymail2");
		testAuthor.setFirstName("first2");
		testAuthor.setLastName("second2");
		num2 = authorService.save(testAuthor);
		Assert.assertNotNull(num2);
		Assert.assertNotNull(authorService.get(num1));
		Assert.assertEquals(2,authorService.getAll().size());
		testAuthor.setBirth(LocalDateTime.now());
		testAuthor.setCreatedDate(LocalDateTime.now());
		testAuthor.setEmail("tytmavbytymail3");
		testAuthor.setFirstName("first3");
		testAuthor.setLastName("second3");
		authorService.update(num1,testAuthor);
		Assert.assertEquals(authorService.get(num1).getFirstName(),"first3");
		Assert.assertEquals(authorService.get(num1).getEmail(),"tytmavbytymail3");
		authorService.delete(num1);
		authorService.delete(num2);
		Assert.assertNull(authorService.get(num1));
		Assert.assertNull(authorService.get(num2));
	}

}