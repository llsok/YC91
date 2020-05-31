package com.yc.java.d0531;

public class Demo1 {
	
	public static void main(String[] args) {
		
		byte a = 100;
		short b = a;   // 自动类型转换 => 隐式转换
		// Type mismatch: cannot convert from short to byte
		// 大的数据类型 转换到 小的数据类型, 就必须使用强制类型转换 => 显式转换
		// Type mismatch: cannot convert from int to short
		// 表达式如果出现多个数据类型, 结果的类型是什么? 答: 是表达式中最大的那个类型 
		b = (short) ( b + 30 ) ;
		// b 的值 是 130
		byte c = (byte) b;		
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		
		// 浮点型赋值给整型, 会出现精度丢失(丢失小数位), 也必须进行强制类型转换
		float e = 3.64f;
		int  f = (int)e;
		System.out.println("e = " + e);
		System.out.println("f = " + f);
		
		char g = 'a';
		// Cannot cast from boolean to int
		// 类型转换必须要类型必须相互兼容
		int h = g + 1;
		System.out.println("h = " + h);
		
		boolean i = true;
		
		//sh = (int)i;
		
	}

}
