package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Person;

public class TestIocAndDI {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person)context.getBean("person");
		System.out.println("name: "+person.getName());
		System.out.println("age: "+person.getAge());
		System.out.println("gender: "+person.getGender());
		System.out.println("proName: "+person.getProfession().getName());
		System.out.println("proNumber: "+person.getProfession().getNumber());
		
	}

}
