package com.yc.java.d0807;

import java.util.Random;

public class Demo3 {
	
	public static void main(String[] args) {
		
		Random random = new Random(); // 不传种子值, 那么java 会使用当前时间戳作为种子值
		Random random1 = new Random(10); // 种子值为10
		Random random2 = new Random(10); // 种子值为10
		System.out.println("========= random1 ==========");
		// 获取随机数
		System.out.println(random1.nextInt());
		System.out.println(random1.nextInt());
		System.out.println(random1.nextInt());
		System.out.println(random1.nextInt());
		// 0~99随机数
		System.out.println(random1.nextInt(100));
		System.out.println(random1.nextInt(100));
		System.out.println(random1.nextInt(100));
		System.out.println(random1.nextInt(100));
		
		// 随机值的种子 (随机值实际上是伪随机)
		// 如果使用相同随机种子创建随机对象, 那么两个随机对象会生成相同随机值
		
		System.out.println("========= random2 ==========");
		// 获取随机数
		System.out.println(random2.nextInt());
		System.out.println(random2.nextInt());
		System.out.println(random2.nextInt());
		System.out.println(random2.nextInt());
		// 0~99随机数
		System.out.println(random2.nextInt(100));
		System.out.println(random2.nextInt(100));
		System.out.println(random2.nextInt(100));
		System.out.println(random2.nextInt(100));
		
	}

}
