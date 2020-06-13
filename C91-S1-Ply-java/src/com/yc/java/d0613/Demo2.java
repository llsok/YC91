package com.yc.java.d0613;

public class Demo2 {

	public static void main(String[] args) {

		// 数组的遍历(迭代)==>循环
		int[] arr0 = new int[10];
		System.out.println("========为 arr0 数组的 所有元素赋值=============");
		// 为 arr0 数组的 所有元素赋值
		for (int i = 0; i < arr0.length; i++) {
			arr0[i] = i + 100;
		}
		System.out.println("========显示  arr0 数组的 所有元素=============");
		// 显示 arr0 数组的 所有元素
		for (int i = 0; i < arr0.length; i++) {
			// i 值 是数组的索引(下标, 元素的序号, 编号, 第 i 个)
			System.out.println(arr0[i]);
		}

		System.out.println("========增强 for 循环 =============");
		// 增强 for 循环 : 数组 和 集合才能使用该循环语法
		for (int a : arr0) {
			// a 就是 数组的元素的值
			System.out.println(a);
		}

		System.out.println("========while 也能对数组循环 =============");
		// while 也能对数组循环
		int i = 0;
		while (i < arr0.length) {
			System.out.println(arr0[i]);
			i ++; 
		}

	}

}
