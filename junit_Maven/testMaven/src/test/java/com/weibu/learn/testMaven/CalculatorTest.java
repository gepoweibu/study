package com.weibu.learn.testMaven;


import junit.framework.Assert;
import junit.framework.TestCase;
/**
 * Junit3.8.1用法测试
 * @author Administrator
 * 所有测试方法命名：public void testAxx()(){}
 *
 */
public class CalculatorTest extends TestCase{
	Calculator c=null;
	@Override
	protected void setUp() throws Exception {
		c=new Calculator();
		System.out.println("run setUp() method");
	}
	public void testAdd() {
		System.out.println("run testAdd() method");
		int result01=c.add(6, 8);
		Assert.assertTrue(result01==14);
		float result02=c.add(3, 4.5f);
		Assert.assertTrue(result02==7.5f);
		float result03=c.add(3.0f, 6);
		Assert.assertTrue(result03==9.0f);
		float result04 = c.add(3.0f, 6.5f);
		Assert.assertTrue(result04==9.5f);
	}
	public void testSub() {
		System.out.println("run testSub() method");
		int result01=c.sub(6, 8);
		Assert.assertTrue(result01==-2);
		float result02=c.sub(3, 4.5f);
		Assert.assertTrue(result02==-1.5f);
		float result03=c.sub(3.0f, 6);
		Assert.assertTrue(result03==-3.0f);
		float result04 = c.sub(3.0f, 6.5f);
		Assert.assertTrue(result04==-3.5f);
	}
	@Override
	protected void tearDown() throws Exception {
		System.out.println("run tearDown() method");
	}
	
}
