package com.yc.javaee.d1203.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
	
	public static void main(String[] args) {
		
		test(new DemoTest());
		
	}

	/**
	 * 给定一个类， 执行里面被标注为 @MyTest 的测试方法
	 * @param testObj
	 */
	public static void test(Object testObj) {
		
		Class<?> cls = testObj.getClass();
		
		// 获取所以后的总有方法
		Method[] methods = cls.getMethods();
		
		for(Method m : methods) {
			MyTest mt = m.getAnnotation(MyTest.class);
			if(mt!=null) {
				// 执行测试方法
				// junit 规定，所有的测试方法不能带参数
				try {
					/**
					 * 执行被MyBefore注解标注的方法 
					 */
					m.invoke(testObj);
					/**
					 * 执行被MyAfter注解标注的方法 
					 */
				} catch (IllegalAccessException | IllegalArgumentException e) {
					e.printStackTrace();
					// 调用方法有问题， 执行方法前产生的异常
				} catch (InvocationTargetException e) {
					// 执行方法时， 方法内部产生的异常
					e.printStackTrace();
					System.out.println("该方法内部错误！");
				}
			}
		}
		
		
	}

}
