package com.weibu.learn.testMaven;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StandardTests {
	@BeforeAll
	static void initAll() {
		System.out.println("run @BeforeAll");
	}

	@BeforeEach
	void init() {
		System.out.println("run @BeforeEach");
	}
	@DisplayName("this is succeedingTest()")
	@Test
	void succeedingTest() {
		System.out.println("run @Test");
	}

	@Test
	void failingTest() {
		System.out.println("run @Test failingTest()");
		fail("a failing test");
	}

	@Test
	@Disabled("for demonstration purposes")
	void skippedTest() {
		// not executed
	}

	@AfterEach
	void tearDown() {
		System.out.println("run @AfterEach");
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("run @AfterAll");
	}
}
