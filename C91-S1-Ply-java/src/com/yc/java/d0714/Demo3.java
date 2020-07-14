package com.yc.java.d0714;

public class Demo3 {

	/**
	 * 	属性多态
	 */
	public static void main(String[] args) {
		
		A b = new B();
		A c = new C();
		
		// new 谁 调 谁
		b.show(); // a = ==> B类的show
		c.show(); // a = ==> C类的show
		
		// 属性多态 ==> 声明是谁就调谁
		
		System.out.println(b.a);  // 100 ==> A类a属性
		System.out.println(c.a);  // 100 ==> A类a属性
		
		B bb = (B)b;  // 强制类型转换    ==>  父类转儿类
		C cc = (C)c;  // 强制类型转换    ==>  父类转儿类
		
		// bb == b 是同一个对象 ==> 内存是同一块内存地址
		System.out.println(bb.a);  // 200 ==> B.a
		System.out.println(cc.a);  // 300 ==> C.a
		
		/**
		 * 	方法多态:  看 = 号的右边
		 * 	属性多态:  看 = 号的左边
		 */
	}
	
	
	
}

class A {
	int a = 100;
	void show() {
		System.out.println("A.a = " + a);
	}
}

class B extends A {
	int a = 200;
	void show() {
		System.out.println("B.a = " + a);
	}
}

class C extends A {
	int a = 300;
	void show() {
		System.out.println("C.a = " + a);
	}
}
