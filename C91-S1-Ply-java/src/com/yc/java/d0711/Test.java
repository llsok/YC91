package com.yc.java.d0711;

public class Test {
	public static void main(String[] args) {
		// Stu s=new Stu();
		// System.out.println(s.b);
		Stu.show();
	}
}

class Stu {
	static int a = 0;
	int b; // 实例变量

	static void show() {
		//b = 56;
		//System.out.println("a=" + b);
	}

	void shot() {
		b = 56;
		a++;
		System.out.println("a=" + b);
	}
}
