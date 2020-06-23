package com.yc.java.d0623;

public class Demo1 {
	
	public static void main(String[] args) {
		
		// 用一个变量表示 N 个数据的 变量
		
		int[] arr1; // 声明数组, 没有赋值 默认值为 null
		
		/**
		 *  Variable must provide either dimension expressions or an array initializer
		 *  	数组定义时必须指定数组的大小( 长度  )  => 数据可以存放的元素的个数
		 */
		int[] arr2 = new int[100];// new 用于创建对象 ( 引用数据类型的变量  ), 每个元素的初始值为 0
		
		// {} 用于定义数组里面的元素值, 里面没有内容表示0个元素
		// 列举元素不需要写数组大小(长度)
		int[] arr3 = new int[] {100,98,88,70}; 
		
		int[] arr4 = {100,98,88,70}; 
		
		/**
		 * 获取数组值的方式是使用 "下标"( 索引, 编号 )
		 */
		System.out.println( arr4[0] );  // 数组的第一个元素的下标值是 0,
		System.out.println( arr4[2] );  // 数组的第3个元素的下标值是 2,
		
		arr4[1] = 95;  // 设置数组的元素值
		arr4[3] = 80;
		
		System.out.println(arr4[1]);
	}

}
