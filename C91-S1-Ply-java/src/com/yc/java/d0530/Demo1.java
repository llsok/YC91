package com.yc.java.d0530;

public class Demo1 {
	
	// eclipse 快捷方式       alt + / 代码提示功能
	public static void main(String[] args) {
		
		byte a = 100;
		// Type mismatch: cannot convert from int to byte
		// 无法将 int 转成 byte
		// 等号右边的数值  字面值 -129
		short b = -129;
		int c = -32769;
		// The literal 99999999999 of type int is out of range 
		// 99999999999 已经超出 int 的最大值
		long d = 99999999999L;
		
		// 十进制
		int e = 10;
		System.out.println(e);
		// 八进制 0开头
		int f = 010;
		System.out.println(f);
		// 十六进制   0x开头    0~9 a~f==>(10~15)
		int g = 0x10;
		System.out.println(g);
		
	}

}
