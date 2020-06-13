package com.yc.java.d0613;

public class Demo1 {

	public static void main(String[] args) {
		
		// 统计 咱们班所有学生 语文成绩
		int a = 97;
		int b = 88;
		
		// 一个变量存放 N 个值 ==> 数组
		// 数组的定义: 1. 类型,  2.大小 ( 长度 )( 数组的元素个数 ) 必须有
		// 创建数组方式一
		int[] arr0 = new int[100];  // 大小不能为负数
		// 数据类型: 基本    引用( 数组, 字符串 ....)
		
		// 创建数组方式二, 直接将元素定义在后面的{} 内, 
		// 数组大小就是 {} 内的元素个数
		char[] arr1 = new char[] {'你','好'};
		
		// 数组定义的方式三
		boolean[] arr2 = {true, false, true};
		
		// 数组的唯一属性, 数组的的元素个数, 大小, 长度
		System.out.println(arr0.length);
		System.out.println(arr1.length);
		System.out.println(arr2.length);
		
		System.out.println("===========华丽的分隔线===========");
		arr0[0] = 100; // 为 arr0 数组的第一个元素赋值
		arr0[99] = 80; // 为 arr0 数组的最后一个元素赋值 = 长度 - 1
		arr0[10] = 70; // 第 11 个元素
		arr0[49] = 30; // 第 50 个元素
		
		System.out.println(arr0[0]);   // 输出数组元素的值 --- 取值
		System.out.println(arr0[99]);
		System.out.println(arr0[10]);
		System.out.println(arr0[49]);
		System.out.println(arr0[1]);  // 第2个元素没有赋值, 默认值为 0
		
		// Array Index Out Of Bounds Exception
		// 数组  索引  超过   边界   异常
		
		arr0[80] = 100; // 这里将会出现数组越界, java 特有
						 // java不允许访问操作数组边界的元素
		
		arr0[-1] = 100; 
		
	}
	
}
