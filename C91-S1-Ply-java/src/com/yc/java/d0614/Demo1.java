package com.yc.java.d0614;

public class Demo1 {
	
	public static void main(String[] args) {
		
		int[] arr1 = {3,4,5,6,7};
		int[] arr2;
		
		// 1.赋值复制 ==> 地址的复制
		arr2 = arr1;
		System.out.println("=========打印 arr2=========");
		for(int a : arr2) {
			System.out.print(a + ",");
		}
		System.out.println(); // 换行
		
		// 修改 arr2 里面的值 , arr1 里面对应的值也会被修改
		// 因为 arr1 和 arr2 是同一个对象(指向同一个堆内存中的地址)
		arr2[2] = 50;
		
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
		System.out.println("==========基本数据类型值复制==========");
		int a = 100;
		int b = a;
		b = 200;
		System.out.println(" a = " + a);
		System.out.println(" b = " + b);
		
	}

}
