package com.yc.java.d0614;

public class Demo3 {
	
	public static void main(String[] args) {
		// 数组的高级复制
		int[] arr1 = {3,4,5,6,7};
		int[] arr2 = {1,1,1,1,1,1,1,1};
		
		// {1,1,1,1,1,5,6,7};
		
		// arr2 ==> {1,1,1,3,4,5,1,1}
		/**
		 * src		原数组   arr1
		 * srcPos  	原数组从第几个元素开始赋值    0   position 位置
		 * dest		目的数组 arr2
		 * destPos	复制到目的数组的第几个元素  3
		 * length	复制的元素个数  3
		 */
		System.arraycopy(arr1, 0, arr2, 3, 3);
		
		// arr1 不变,  arr2 ==> {1,1,1,3,4,5,1,1}
		
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
