package com.yc.javaee.d1203;

// 属性类
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
// 方法类
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;

public class Demo1 {
	
	@Test
	public void test1() {
		System.out.println("=========String=========");
		action("abc");
		System.out.println("=========Date=========");
		action(new Date());
		
		A a = new A();
		B b = new B();
		
		System.out.println("========A==========");
		
		action(a);
		
		System.out.println("=========B=========");
		action(b);
		
		/**
		 * 类的构成元素：
		 * 1. 属性
		 * 2. 方法
		 * 3. 构造方法
		 * 4. 块
		 * 5. 内部类
		 */
	}
	
	public static void action(Object obj) {
		
		// 获取到 obj 的所有的属性， 方法，构造方法。。。 （反射）
		//obj.subtring(); // String
		
		//obj.getTime();  // Date
		
		Class<?> cls = obj.getClass(); // 或去类对象
		
		// getFields 共有属性 public
		// getDeclaredFields 获取定义的属性
		Field[] fields = cls.getDeclaredFields();
		
		System.out.println("======== 带 Declared ===========");
		for( Field f : fields) {
			System.out.println(f.getName() + "\t" + f.getType());
		}
		
		System.out.println("======== 不带 Declared ===========");
		fields = cls.getFields();
		for( Field f : fields) {
			System.out.println(f.getName() + "\t" + f.getType());
		}
		
		try {
			Method method = cls.getDeclaredMethod("substring", int.class, int.class);
			Object result = method.invoke(obj, 1,2);
			System.out.println("--------substring: "+ result);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("获取方法错误 :" + cls);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("执行方法错误:" + cls);
		}
	}
	

}



class A {
	protected int a;
	public  int b;
}

class B extends A{
	protected int c;
	public  int d;
}














