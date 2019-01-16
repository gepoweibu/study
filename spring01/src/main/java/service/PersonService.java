package service;

import org.springframework.stereotype.Component;

@Component("PersonService")
//注册dean 属性name=PersonService
public class PersonService {
	public void doSomething() {
		System.out.println("---Do something in here---");
	}
	public void anotherMethod() {
		System.out.println("---Hello spring aop---");
	}
}
