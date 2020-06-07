package com.yc.java.d0607;

import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		// 给定3个数a,b和c,输出最大的数。
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入a值: ");
		int a = scanner.nextInt();
		System.out.print("请输入b值: ");
		int b = scanner.nextInt();;
		System.out.print("请输入c值: ");
		int c = scanner.nextInt();;
		
		int max;
		// 求 a和b最大值
		if(a > b) {
			max = a;
		} else {
			max = b;
		}
		// 求 max和c最大值
		if(max < c) {
			max = c;
		}
		
		System.out.println("最大值是: " + max);
		
		//1. 请同时输出最小值
		//2. 请使用 条件表达式判断大小
		int min;
		min = a < b ? a : b;
		min = min < c ? min : c;
		System.out.println("最小值是: " + min);
		
	}
	
}
