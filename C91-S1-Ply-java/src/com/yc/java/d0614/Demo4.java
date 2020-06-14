package com.yc.java.d0614;

public class Demo4 {
	
	public static void main(String[] args) {
		
		// 二维数组的定义
		int[][] arr = new int[2][3]; // 行    列
		// arr[0] ==> {1,2,3}
		// arr[1] ==> {4,5,6}
		// 二维数组的赋值
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		
		System.out.println(arr[1][0]);
		
		// 多维数组,除了第一维的长度必须设置之外, 后面的维度的长度可以不设置(可以灵活的设置)
		int[][] arr1 = new int[100][];
		
		arr1[0] = new int[] {1,2,3}; // 迪拜塔第一层
		arr1[1] = new int[] {1,2,3,4,5}; // 迪拜塔第二层
		
		// 多维数组的维度数量没有限制
		// 7维数组
		int[][][][][][][] arr2 = new int[5][][][][][][];
		// arr2[0]; ==>  6维数组
		
		// 三维世界的人看到是 二维影像,   二维世界的人看到是一维影像
		
	}

}
