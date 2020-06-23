package com.yc.java.d0623;

import java.util.Arrays;

public class Demo5 {

	public static void main(String[] args) {
		// 多维数组 == 二维2D 三维3D

		// 盗梦空间

		// 一维数组 { 2 , 3 , 4 , 5 , 6 }
		// 二维数组 { {2,3,4} , {6,7,8} , .... }
		// 三维数组 { {{1,2},{3,4},{5,6}} , .... }
		// N 维数组

		// 定义多维数组
		int[][] arr2; // 二维数组
		int[][][] arr3; // 三维数组

		// java 中的数组长度是固定的, 在定义时必须明确指定

		int[][] arr4 = new int[2][3]; // 例子: { {1,2,3} , {4,5,6} };
		int[][] arr5 = new int[3][2]; // 例子: { {1,2} , {4,5} , {6,7} };

		// 多维数组的定义,运行只定义第一维度的长度
		int[][] arr6 = new int[3][]; // 例子: { { ? } , { ? } , { ? } };
		arr6[0] = new int[2];
		arr6[1] = new int[] { 1, 2, 3 };
		arr6[2] = new int[] { 4, 5, 6, 7 };

		// 多维数组后面的维度的长度可以不一样

		// { { 0,0 } , { 1, 2, 3 } , { 4, 5, 6, 7 } }

		// arr6.length ==> int[3][] ==> 3
		System.out.print("{");
		for (int i = 0; i < arr6.length; i++) {
			System.out.print("{");
			// arr6[i]; // {0,0} 或 { 1, 2, 3 }
			/*for (int j = 0; j < arr6[i].length; j++) {
				// 内部 for 是输出  二维数组内部 一维数组的内容
				System.out.print(arr6[i][j] + ",");
			}*/
			// 增强for循环
			for( int a  : arr6[i]) {
				System.out.print(a + ",");
			}
			System.out.print("}");
		}
		System.out.println("}");
	}

}
