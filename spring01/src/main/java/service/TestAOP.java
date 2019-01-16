package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonService ps = (PersonService)context.getBean("PersonService");
		TestAfterService tas = (TestAfterService)context.getBean("TestAfterService");
		ps.doSomething();
		ps.anotherMethod();
		tas.run();
	}

}
