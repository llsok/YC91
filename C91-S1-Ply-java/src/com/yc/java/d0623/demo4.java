package com.yc.java.d0623;

// 导入 Arrays 类, 数组工具类
import java.util.Arrays;

public class demo4 {

	public static void main(String[] args) {

		// 基本数据类型变量值的复制
		int a = 100;
		int b = a; // 将 a 值赋值给 b , 将 a 值复制给 b
		b++;
		System.out.println(a);
		System.out.println(b);

		/**
		 * 	数组复制:
		 * 	1. 引用复制
		 * 	2. 克隆复制
		 * 	3. 高级复制 
		 */
		System.out.println("=========引用复制============");
		// 引用复制
		int[] aa = { 100, 200, 300 };
		int[] bb = aa;
		int[] cc = bb;
		System.out.println(Arrays.toString(aa)); // 打印数组aa
		System.out.println(Arrays.toString(bb)); // 打印数组bb
		System.out.println(Arrays.toString(cc));
		aa[1] = 250;
		System.out.println(Arrays.toString(aa)); // 打印数组aa
		System.out.println(Arrays.toString(bb)); // 打印数组bb
		System.out.println(Arrays.toString(cc));
		// 原因是: 数组是引用数据类型,
		// 引用复制就是复制数组的地址, 复制完之后 2个变量指向同一个数组
		System.out.println("==========克隆复制===========");
		// 克隆复制: 1. 复制的结果是2个独立的数组, 2要使用数组的clone 函数
		aa = new int[] { 100, 200, 300 }; // 重新赋值, 恢复原值
		bb = aa.clone(); // 执行 aa clone 方法
		cc = bb.clone();
		System.out.println(Arrays.toString(aa)); // 打印数组aa
		System.out.println(Arrays.toString(bb)); // 打印数组bb
		System.out.println(Arrays.toString(cc));
		aa[1] = 250;
		System.out.println(Arrays.toString(aa)); // 打印数组aa
		System.out.println(Arrays.toString(bb)); // 打印数组bb
		System.out.println(Arrays.toString(cc));

		System.out.println("==========高级复制===========");
		// 高级复制
		// 1. 使用 System.arraycopy函数复制
		// 2.不是用于产生新的数组, 用于进行数组之间的值的复制
		int[] aaa = { 1, 2, 3, 5, 6 };
		int[] bbb = { 7, 8, 9, 10, 11 }; // 7 8 1 2 3
		
		/**
		 * src 		原数组
		 * srcPos	从原数组第几个元素开始复制
		 * dest		目标数组
		 * desPost	粘贴到目标数组的第几个元素
		 * length	复制几个元素
		 */
		System.arraycopy(aaa, 0, bbb, 2, 3);
		System.err.println(Arrays.toString(aaa));
		System.err.println(Arrays.toString(bbb));
		
		
		//  练习题 : bbb ==>  7 1 2 10 11

	}

}
