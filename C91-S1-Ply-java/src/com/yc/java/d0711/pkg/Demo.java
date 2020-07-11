package com.yc.java.d0711.pkg;

import com.yc.java.d0711.pkg.sub.B;

// Demo 继承B 类, b.c 才能被 Demo 类的对象访问
public class Demo extends B{
	
	public static void main(String[] args) {
		A a = new A();
		
		// a 是私有 只能在 A 的内部访问
		// System.out.println(a.a);
		// a.b 能访问的原因:  A 与 Demo 同包默认
		System.out.println(a.b);
		// a.c 能访问的原因:  A 与 Demo 同包 protected(同包+ 父子)
		System.out.println(a.c);
		System.out.println(a.d);
		
		/**
		 * B 类与 A 类的结构完全相同
		 */
		B b = new B();
		
		// a 是私有 只能在 A 的内部访问
		// System.out.println(b.a);
		// a.b 能访问的原因:  B 与 Demo 不同包
		// System.out.println(b.b);
		// a.c 能访问的原因:  B 与 Demo 不同包 protected(同包+ 父子)
		//System.out.println(b.c);
		System.out.println(b.d);
		
	}
	// test 是对象方法, 可以访问到父类的属性, 前提条件: 父类的属性必须是被 protected 修饰
	void test() {
		// a 是私有 只能在 A 的内部访问
		//System.out.println(a);
		// a.b 能访问的原因:  B 与 Demo 不同包
		//System.out.println(b);
		// a.c 能访问的原因:  B 是 Demo的父类       protected(同包+ 父子)
		System.out.println(c);
		System.out.println(d);

	}

}
