package ua.nic.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.nic.config.AppConfig;
import ua.nic.entity.Publisher;


public class PublisherServiceTest {

	private static BaseService<Publisher> publisherService;

	private Publisher testPublisher;
	private int num1,num2;

	@BeforeClass
	public static void init() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		publisherService = (BaseService<Publisher>) applicationContext.getBean("publisherService");
	}

	@Test
	public void testAllCrudOperation() {
		testPublisher = new Publisher();
		testPublisher.setName("EKSMO");
		testPublisher.setCity("Chernivtsi");
		num1 = publisherService.save(testPublisher);
		Assert.assertNotNull(num1);
		testPublisher.setName("AVTB");
		testPublisher.setCity("Chernivtsi");
		num2 = publisherService.save(testPublisher);
		Assert.assertNotNull(num2);
		Assert.assertNotNull(publisherService.get(1));
		Assert.assertEquals(2,publisherService.getAll().size());
		testPublisher.setName("EKSMOTest");
		testPublisher.setCity("ChernivtsiTest");
		publisherService.update(num1,testPublisher);
		Assert.assertEquals(publisherService.get(num1).getName(),"EKSMOTest");
		Assert.assertEquals(publisherService.get(num1).getCity(),"ChernivtsiTest");
		publisherService.delete(num1);
		publisherService.delete(num2);
		Assert.assertNull(publisherService.get(num1));
		Assert.assertNull(publisherService.get(num2));
	}

}