package com.yc.java.d0606;

public class Demo4 {

	public static void main(String[] args) {
		
		// break ==> 中断执行
		// continue ==> 回到循环起始处,  也就是开始下一次循环
		
		for (int i = 0 /* 定义循环变量 */ ; i < 100/* 退出循环的条件 */ ; i++ /* 循环变量自加 */ ) {
			System.out.println(i + "  你好");
			if(i == 49) {
				break; // 当 i等于49 就退出
			}
		}
		
		System.out.println("==========================");
		for (int i = 0 /* 定义循环变量 */ ; i < 100/* 退出循环的条件 */ ; i++ /* 循环变量自加 */ ) {
			if(i > 49) {
				System.out.println(i + "  快下课了");
				continue; // continue 会跳过循环后面语句, 直接开始下一次循环
			}
			System.out.println(i + "  你好");
		}
		
	}
}
