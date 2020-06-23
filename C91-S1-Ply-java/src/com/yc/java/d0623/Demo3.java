package com.yc.java.d0623;

public class Demo3 {

	public static void main(String[] args) {

		// 求最大值 or 最小值
		// 统计数组中的 奇数 偶数 质数
		// 数组求和, 求平均值, 查找某个值

		int[] arr1 = { 37, 47, 18, 457, 6, 3, 43, 88, 56 };
		int max = 0;
		int min = 1000;
		for (int a : arr1) {
			if (a > max) {
				max = a;
			}
			if (a < min) {
				min = a;
			}
		}
		System.out.println("最大值是: " + max);
		System.out.println("最小值是: " + min);

		
		int j = 0; // 奇数的总数
		for (int i = 0; i < arr1.length; i++) {
			if(  arr1[i] % 2 != 0 ) {  // 除以2 余数不等于 0
				j ++;
			}
		}
		System.out.println("奇数的个数是: " + j);
		System.out.println("偶数的个数是:  ????");
		
		// 定义求和的计数器
		int sum = 0;
		int i = 0;
		while( i < arr1.length  ) {
			sum += arr1[i];
			i ++;
		}
		
		System.out.println("总和是:" + sum);
		
		System.out.println("平均数是: ????");
		
		System.out.println("是否包含 数字 3 : ????");
		
	}

}
