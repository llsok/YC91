package com.yc.java.d0531;

public class Demo4 {
	
	public static void main(String[] args) {
		System.out.println("==========&&===========");
		boolean a;
		int b = 5;
		int c = 6;
		a = b > 6 & c++ > 7;
		System.out.println( " b > 6 & c++ > 7  = " + a);
		System.out.println( " c  = " + c);
		
		// 还原 c 值
		c = 6;
		a = b > 6 && c++ > 7;
		System.out.println( " b > 6 && c++ > 7  = " + a);
		System.out.println( " c  = " + c);
		
		System.out.println("========== || ===========");
		c = 6;
		a = b < 6 | c++ > 7;
		System.out.println( " b < 6 | c++ > 7  = " + a);
		System.out.println( " c  = " + c);
		
		c = 6;
		a = b < 6 || c++ > 7;
		System.out.println( " b < 6 || c++ > 7  = " + a);
		System.out.println( " c  = " + c);
		
		// 没有特殊情况,从效率上考虑, 我们都是用  && || 进判断
	}

}
