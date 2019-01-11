package com.weibu.learn.testMaven;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorJpTest {
	private Calculator c=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("start testing");
		System.out.println("run @BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("run @AfterAll");
		System.out.println("finish testing");
	}

	@BeforeEach
	void setUp() throws Exception {
		c=new Calculator();
		System.out.println("run @BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		c=null;
		System.out.println("run @AfterEach");
	}

	@Test
	void testAddIntInt() {
		assertTrue(c.add(3, 3)==6);
	}

	@Test
	void testAddFloatInt() {
		assertTrue(c.add(4.5f, 5)==9.5f);
	}

	@Test
	void testAddIntFloat() {
		assertTrue(c.add(2, 5.6f)==7.6f);
	}

	@Test
	void testAddFloatFloat() {
		assertTrue(c.add(4.5f, 5.5f)==10.0f);
	}

	@Test
	void testSubIntInt() {
		assertTrue(c.sub(7, 3)==4);
	}

	@Test
	void testSubFloatInt() {
		System.out.println(c.sub(6.7f,4));
		System.out.println(6.7-4);
		System.out.println("程序中应尽量避免浮点数比较");
		System.out.println("浮点数在计算机中存储其本身就是近似值");
		System.out.println("解决办法： 使用BigDecimal类进行计算比较");
		BigDecimal b1=new BigDecimal(c.sub(6.7f,4));
		//assertTrue(c.sub(6.7f,4)==2.7f);
		BigDecimal b2=new BigDecimal(2.6999998f);
		assertTrue(b1.compareTo(b2)==0);
	}

	@Test
	void testSubIntFloat() {
		assertTrue(c.sub(9, 3.3f)==5.7f);
	}

	@Test
	void testSubFloatFloat() {
		assertTrue(c.sub(66.0f, 30.5f)==35.5f);
	}

}
