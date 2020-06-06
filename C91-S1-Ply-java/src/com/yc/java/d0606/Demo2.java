package com.yc.java.d0606;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {

		// 用户输入数字(1~7), 我们将数字转成星期几(星期一~星期天)
		// if 和 switch 可以互转

		// OOP 语法
		Scanner sc = new Scanner(System.in); // 创建屏幕录入对象
		System.out.print("请输入星期数(1~7): ");
		int a = sc.nextInt();

		switch (a) { // a 必须为整数 或 字符串(java 1.7支持)
		case 1:
			System.out.println("星期一");
			break;// break 表示中断
		case 2:
			System.out.println("星期二");
			break;
		case 3:
			System.out.println("星期三");
			break;
		case 4:
			System.out.println("星期四");
			break;
		case 5:
			System.out.println("星期五");
			break;
		case 6:
			System.out.println("星期六");
			break;
		case 7:
			System.out.println("星期天");
			break;
		default: // 默认的分支
			System.out.println("您输入的不正确");
		}

		System.out.println("=======================");
		System.out.print("请输入月份(1~12): ");
		a = sc.nextInt();
		switch (a) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("您输入是大月");
			break;
		case 2:
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("您输入是小月");
			break;
		default:
			System.out.println("您输入错误");
		}
		// 输入13 也会显示小月, 请判断 小于1 或 大于12的月份是输入错误

	}

}
