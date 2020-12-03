package com.yc.javaee.d1203;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.servlet.annotation.WebServlet;

@WebServlet("/web.s")

@Test("test")
public class Demo2 {
	
	@Test(name = "test",  type = {"type","type2","type3"})
	public int age;
	
	// 前面带包名，表示全路径引用，解决同名冲突
	@org.junit.Test
	public void test1() throws NoSuchFieldException, SecurityException {
		
		/**
		 * 获取类对象的方法：
		 * 1. 对象.getClass()
		 * 2. 类名.class
		 * 3. Class.forName("类路径") 
		 */
		Test t = Demo2.class.getAnnotation(Test.class);
		
		System.out.println(t.name());
		System.out.println(Arrays.toString(t.type()));
		System.out.println(t.value());
		
		/**
		 * 默认情况下子类不会继承父类的注解
		 */
		t = SubDemo2.class.getAnnotation(Test.class);
		
		System.out.println(t.name());
		System.out.println(Arrays.toString(t.type()));
		System.out.println(t.value());
		
		/**
		 * 获取子类age属性上的注解
		 */
		Field ageField = SubDemo2.class.getField("age");
		t = ageField.getAnnotation(Test.class);
		
		System.out.println(t.name());
		System.out.println(Arrays.toString(t.type()));
		System.out.println(t.value());
	}

	@Override // 该方法是父类定义的放
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	

}

/**
 * Demo2 的子类
 */
class SubDemo2 extends Demo2{
	
}





