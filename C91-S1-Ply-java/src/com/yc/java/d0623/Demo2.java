package com.yc.java.d0623;

public class Demo2 {

	public static void main(String[] args) {
		// 数据的迭代(遍历, 循环)
		// 数组的唯一属性 : length 表示数据的元素总个数( 大小, 长度)

		byte[] arr1 = new byte[10];
		System.out.println(arr1.length);

		// length 用途 : 让我访问不会越界, 遍历的时候要使用 length

		// 安全的访问数组

		// C 语言获取长度 int[] a sizeof(a) / sizeof (int)
		// int a[10] ==> a[15]; C 没有越界的问题

		// java 的数据有越界的问题

		// Array Index Out Of Bounds Exception: 10
		// 数组越界 访问了第 11 个元素
		// java 访问数组中的元素, 不能超过数据大小的边间 0 ~ length - 1
		// System.out.println(arr1[ 10 ]);
		// System.out.println(arr1[-1]);

		System.out.println("=====================");
		// 将数组中的所有元素访问一次的过程叫迭代( 遍历 )
		// 普通的for循环
		float[] arr2 = { 85, 96, 78, 65, 99, 79 };
		for (int i = 0; i < arr2.length; i++) {
			// 给每个元素 + 5
			arr2[i] = arr2[i] + 5;
			System.out.println(arr2[i]);
		}
		System.out.println("-----------验证数组的内容----------");
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		
		
		float[] arr3 = { 85, 96, 78, 65, 99, 79 };
		System.out.println("=====================");
		// 增强 for 循环
		for (  float a : arr3 ) {
			// 给每个元素 + 5
			a = a + 5;
			// a 就是数组的当前元素 arr2[0] ~ arr2[9]
			System.out.println(a);
		}
		System.out.println("-----------验证数组的内容----------");
		for (  float a : arr3 ) {
			System.out.println(a);
		}
		
		
		/**
		 * 	普通的for循环  可以修改数组的元素值
		 *	增强for循环 只能读取  不可以修改数组的元素值
		 */
		
		

	}

}
