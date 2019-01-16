package service;

import org.springframework.stereotype.Component;

@Component("TestAfterService")
public class TestAfterService {
	public void run() {
		System.out.println("---Hai I am run method at TestAfterService class---");
	}
}
