package com.yc.java.d0530;

public class Demo3 {
	
	public static void main(String[] args) {
		
		char a = 'a';
		char b = '1';
		
		char c = '\u0068';
		
		System.out.println(a);  // syso + alt + /
		System.out.println(b);
		System.out.println(c);
		
		char d = '\'';   // \ 转义
		char e = '\\';   // \ 转义
		
		System.out.println(d);
		System.out.println(e);
		
		char f = 'a'; 
		int  g = f + 1;  // char 可以作为整数进行计算
		
		System.out.println(g);
		
		char h = (char) g; // 类型转换  整数转 字符
		
		System.out.println(h);
		
		char i = '\055';  // 八进制表示 完全是为了兼容 c里面字符表示方式
		
	}

}
