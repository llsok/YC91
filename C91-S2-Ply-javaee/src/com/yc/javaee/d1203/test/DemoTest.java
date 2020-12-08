package com.yc.javaee.d1203.test;

/**
 * 作业： 完成MyBefore 和 MyAfter 注解定义和使用
 */
public class DemoTest {
	
	// @MyBefore  	可选
	public void before() {
		System.out.println("每个被测试的方法执行前，执行的方法");
	}
	
	// @MyAfter		可选
	public void after() {
		System.out.println("每个被测试的方法执行后，执行的方法");
	}
	
	/**
	 * @MyTest注解是我们自定义注解
	 */
	@MyTest
	public void test1() {
		System.out.println("这是 test1");
	}

	/**
	 *  test2没有 @MyTest 注解
	 */
	@MyTest
	public void test2() {
		System.out.println("这是 test2");
	}

	@MyTest
	public void test3() {
		System.out.println("这是 test3");
	}

}
