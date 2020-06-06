package com.yc.java.d0606;

public class Demo3 {

	public static void main(String[] args) {
		/**
		 * 循环语句 for 应用 循环次数已知的情况下 while 应用 循环次数未知的情况下
		 * 
		 * 程序中 0 表示的第一个数字
		 */
		for (int i = 0 /* 定义循环变量 */ ; i < 100/* 退出循环的条件 */ ; i++ /* 循环变量自加 */ ) {
			System.out.println(i + "  你好");
		}

		/**
		 * for ( A ; B ; C){ D }
		 * 
		 * 开始 A -> B -> D -> C -> B -> D -> C -> B -> D -> C -> B 退出
		 * 
		 * for ( int i=0 ; i<3 ; i++){ //.... }
		 * 
		 */

		// while ( boolean 表达式 ==> true 执行循环, false 退出循环 )

		int i = 0;
		while (i < 100) {
			System.out.println(i + "  你好");
			// 循环变量的自加要你在循环内部实现
			i++;
		}
		
		//  存款年利息是  0.003,  请问 存1万, 多少年后, 本金 + 利息是达到2万
		double a = 10000; // 10000 本金
		double b = 0.003;
		int y = 0;			// 年数
		while(a<=20000) {
			a *= 1 + b;
			y ++;
		}
		System.out.println(y + "年之后,本金达到:" + a);
		
		// 计算 2万,本金 20年后, 本金 + 利息是多少
		a = 20000;
		y = 0;
		do { // 先执行再判断
			a *= 1 + b;
			y ++;
		} while( y<20 );
		
		System.out.println(y + "年之后,本金达到:" + a);
		
	}

}
