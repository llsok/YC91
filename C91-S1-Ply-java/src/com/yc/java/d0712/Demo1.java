package com.yc.java.d0712;
/**
 * 	继承中的构造方法
 */
public class Demo1 {
	
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.a);
		System.out.println(b.b);
		System.out.println(b.z);
		// B 是 Z 孙子 继承了 Z 和 A 的属性
	}

}

class Z {
	int z;
	public Z() {
		System.out.println("===z====");
		int i = 1 / 0; // 出现错误
		z = 300;
	}
}

class A extends Z {
	int a;
	public A() {
		System.out.println("===a====");
		a = 100;
	}
}

class B extends A{
	int b;
	public B() {
		System.out.println("===b====");
		// 当实例化子类的对象时，必须先执行父类的构造方法，然后再执行子类的构造方法
		b = 200;
	}
}
