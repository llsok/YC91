package com.yc.java.d0614;

public class Demo2 {

	public static void main(String[] args) {
		int[] arr1 = {3,4,5,6,7};
		int[] arr2;
		
		// 2.克隆复制
		arr2 = arr1.clone(); // 克隆方法,返回一个与原数组一模一样的数组
		// 分别修改两个数组中的原数字
		arr1[0] = 33;
		arr2[4] = 77;
		
		System.out.println("=========打印 arr1=========");
		for(int a : arr1) {
			System.out.print(a + ",");
		}
		System.out.println();
		
		System.out.println("=========打印 arr2=========");
		for(int a : arr2) {
			System.out.print(a + ",");
		}
		System.out.println();
	}
}
