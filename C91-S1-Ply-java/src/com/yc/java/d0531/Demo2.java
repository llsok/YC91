package com.yc.java.d0531;

public class Demo2 {

	public static void main(String[] args) {

		int a = 1 + 2;
		// The value of the local variable b is not used
		//  b变量未使用
		int b = - 5;
		System.out.println("a = " + a);
		a = a + 1;  // 赋值 自加1
		System.out.println("a = " + a);
		a++;
		System.out.println("a = " + a);
		++a;
		System.out.println("a = " + a);
		
		// a++ 先求和 再自加
		b = 5 + a++;
		System.out.println("b = " + b);
		
		// a = 6;
		// ++a 先自加 再求和
		b = 5 + ++a;
		System.out.println("b = " + b);
		
		System.out.println("a = " + a);
		
		b = a / 6;
		System.out.println("a / 6 = " + b);
		
		b = a % 6;  // 取模, 取余
		System.out.println("a % 6 = " + b);
		
	}

}
