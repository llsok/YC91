package com.yc.java.d0613;

import java.util.Random;// 引入随机对象

public class Demo3 {

	public static void main(String[] args) {
		// 定义, 取值赋值, 遍历

		// 定义一个数组: 随机赋值 0~100 的数字
		// 统计所有元素的总和
		// 计算平均值
		// 查找某个数字, 返回该数字的出现的第一个索引(下标)
		// 查找最大值, 最小值

		// 创建随机对象 OOP 语法
		Random random = new Random();

		System.out.println("==========定义一个数组: 随机赋值 0~100 的数字===========");
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			// 如果对数组元素赋值, 不能使用增强 for 循环
			// 增强 for 循环 只能查看数组元素的内容, 不可赋值
			arr[i] = random.nextInt(101); // nextInt 随机产生一个比输入值小的数字
		}

		System.out.println("==========统计所有元素的总和===========");
		// 定义记录总和的变量
		int sum = 0;
		// 增强for
		for (int a : arr) {
			System.out.print(a + ",");
			sum += a;
		}
		System.out.println();
		System.out.println("总和是: " + sum);
		System.out.println("平均值是: " + sum / arr.length);

		System.out.println("======查找某个数字, 返回该数字的出现的第一个索引(下标)======");
		int number = 50; // 要搜索的数字
		int numberIndex = -1; // 该数字的索引

		// 循环每一个元素(遍历)
		for (int i = 0; i < arr.length; i++) {
			// 判断该元素的值是否 == number
			if (arr[i] == number) {
				// 如果相等则将 该元素下标 赋值给 numberIndex
				numberIndex = i;
				// 如果相等则退出循环
				break;
			}
		}
		System.out.println("第一个" + number + "出现在第" + numberIndex + "字符");

		System.out.println("======查找最大值, 最小值======");
		int max = -1;
		int min = 101;
		for (int a : arr) {
			if (a > max) {
				max = a;
			}
			if (a < min) {
				min = a;
			}
		}
		System.out.println("最大值是: " + max);
		System.out.println("最小值是: " + min);

		/**
		 * 	请统计该数组中有多少个: 
		 * 	1 奇数, 
		 * 	2 偶数, 
		 *  3 个位数, 
		 *  4 大于  90 的数
		 *  5 大于平均值的数
		 *  6 质数(只能被1和自身整除的数字)
		 */
		// 遍历每个元素, 判断是否是奇数, 如果是就给计数器+1
		int jishu = 0;
		// 遍历每个元素
		for (int i = 0; i < arr.length; i++) {
			// 判断是否是奇数
			if (arr[i] % 2 == 1) {
				// 计数器+1
				jishu += 1;
			}
		}
		System.out.println("奇数的数量是:" + jishu);

		// 定义统计个位数的变量
		int gwshu = 0;
		// 遍历每个元素
		for (int i = 0; i < arr.length; i++) {
			// 判断是否是个位数
			if (arr[i] < 10) {
				// 计数器+1
				gwshu++;
			}
		}
		System.out.println("个位数的数量是:" + gwshu);

		/**
		 * 平均数
		 */
		int avg = sum / arr.length; // 计算平均数

		System.out.println("==========判断质数===========");
		int num = 82;
		boolean isZhi = true; // 判断结果默认是质数
		// 起始值应该从最小质数 2 开始
		for (int i = 2; i < num; i++) {
			// 判断是否整除 ==> 不是质数
			if(num % i == 0) {
				isZhi = false;
				// 判断出不是,就可以不用再测试了
				break;
			}
		}
		if(isZhi) {
			System.out.println(num + "是质数");
		}  else {
			System.out.println(num + "不是质数");
		}
		
		
		System.out.println("==========统计质数的数量===========");
		int zhishu = 0;
		for(int j = 0 ; j<arr.length; j++ ) {
			boolean isZhi1 = true;
			// 获取arr数组当前循环的的元素值
			int arrValue = arr[j]; 
			for (int i = 2; i < arrValue; i++) {
				// 判断是否整除 ==> 不是质数
				if(arrValue % i == 0) {
					isZhi1 = false;
					// 判断出不是,就可以不用再测试了
					break;
				}
			}
			// 判断是质数 那么计算器 加一
			if(isZhi1) {
				System.out.print(arrValue + ",");
				zhishu ++;
			}
		}
		System.out.println();
		System.out.println("质数的数量是:" + zhishu);
	}

}
