package com.yc.java.d0530;

public class Demo2 {
	
	public static void main(String[] args) {
		boolean a = true; // 真       注意编写错误: ture   play paly
		boolean b = false; // 假
		
		// 浮点型 : 不能精确表示 数字
		// Type mismatch: cannot convert from double to float
		float c = 3.14F; // 默认的浮点型是 double
		double d = 3.14;
		double e = 1.001e3;  // e3 ==> 10^3  浮点数支持科学计数法
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		float f = 1234567889899999f;   // 1.用float 2.数字足够大
		float g = f + 1;   // f 加 1   g > f
		
		boolean h =    f == g  ;   // 比较 f 和 g 的值, 将结果赋值给 h
		System.out.println( "h = " +  h);  // 字符串拼接
		
		// h = true  表示  f == g  f 和 g 值是 一样大
		
		// 浮点数不能表示精确的值
		
		// ctrl + s  保存当前文件, 不保存, java 文件不会被编译, 就看不到最新的代码执行结果
		
		double f2 = 0.1 + 0.2;  //  奇葩  0.30000000000000004
		
		System.out.println("f2 = " +  f2);
		
		System.out.println(0.1 + 0.2);
		
		
		boolean b2 = 0.99999999f == 1f;
		
		System.out.println("b2 = " +  b2);
		
	}

}
