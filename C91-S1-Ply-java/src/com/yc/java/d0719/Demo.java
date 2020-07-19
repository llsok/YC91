package com.yc.java.d0719;

/**
 * final 关键字  终结
 * 	可以修饰:  
 * 		类 	: 该类不能被继承  => 断子绝孙
 * 		方法	: 该方法不能被重写
 * 		变量	: 该变量值不能被重新赋值
 * 
 * 	abstract final 是互斥的关键字
 */
public class Demo {
	
	// java 常量定义
	public static final int A = 1;
	
	final void test() {
		
		final int a;
		a = 1;
		// The final local variable a cannot be assigned. 
		// It must be blank and not using a compound 
		// 该变量值不能被重新赋值
		// a = 2;
		
	}
}
// The type SubDemo cannot subclass the final class Demo
// 不能继承于一个终结的类
class SubDemo extends Demo{
	// Cannot override the final method from Demo
	// 不能重写被终结的方法
	// void test() {}
	
}
