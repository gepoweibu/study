package com.weibu.learn.testMaven;

import junit.framework.Test;
import junit.framework.TestSuite;
/**
 * TestSuite类的简单用法。
 * @author Administrator
 *	测试方法必须是public static Test suite(){}
 */
public class TestSuiteDemo {
	public static Test suite() {
		TestSuite suite=new TestSuite();
		//添加测试用例集合(TestCase子类)
		suite.addTestSuite(CalculatorTest.class);
		//创建具体测试用例
		Test test=TestSuite.createTest(CalculatorTest.class, "testAdd");
		suite.addTest(test);
		return suite;
	}
}
