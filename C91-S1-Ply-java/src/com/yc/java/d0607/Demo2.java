package com.yc.java.d0607;

public class Demo2 {
	
	public static void main(String[] args) {
		
		int a = 5;
		int b = 8;
		
		// 交换变量值,必须使用第3个变量
		int c = a;
		a = b;
		b = c;
		
		System.out.println(" a = " + a);
		System.out.println(" b = " + b);
		
		// 不使用第 3 变量, 交换2个变量的值,  华为的面试题
		System.out.println("======================");
		// 恢复 a b 的原值
		a = 5;
		b = 8;
		
		a = a + b;   // a=13   b=8
		b = a - b;   // a=13   b=5
		a = a - b;   // a=8    b=5
				
		System.out.println(" a = " + a);
		System.out.println(" b = " + b);
		
		// 换一种写法
		System.out.println("======================");
		// 没有恢复 a b 的值
		a += b;
		b = a - b;
		a -= b;
		System.out.println(" a = " + a);
		System.out.println(" b = " + b);
		
	}

}
