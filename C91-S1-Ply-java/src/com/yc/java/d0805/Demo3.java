package com.yc.java.d0805;

public class Demo3 {
	
	public static void main(String[] args) {
		
		System.out.println("主程序开始");
		
		// try 嵌套
		try {
			try {
				int i = 1/ 0; // jvm 抛出 ArithmeticException 异常
			} catch (ArithmeticException e) {
				System.out.println("1. 捕获异常: " + e.getMessage());
				// 将异常继续抛出, throw 关键字可以抛出异常,   ==>  烫手的山芋
				throw e;
			}
		} catch (ArithmeticException e) {
			System.out.println("2. 捕获异常: " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("主程序结束");
		
	}

}
