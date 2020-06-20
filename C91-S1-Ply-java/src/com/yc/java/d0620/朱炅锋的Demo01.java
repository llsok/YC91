package com.yc.java.d0620;

import java.util.Random;

public class 朱炅锋的Demo01 {
	public static void main(String[] args) {
		/*
		 * 扑克牌分析 1.打印一整副扑克 
		 * 2.洗牌（Random 随机对象 ） 
		 * 3.发牌 
		 * 4.整牌 
		 * 5.找牌，找黑桃3=>出牌
		 * 
		 * java 方法（函数）定义
		 * 
		 * 实现：54张牌==>去掉两张王=> 52 = > 每个花色13张
		 * 
		 * 
		 */
		// 创建扑克牌 52张
		int[] pokers = new int[52];

		for (int i = 0; i < pokers.length; i++) {
			// 将 i赋值给当前数组元素
			pokers[i] = i;
			System.out.print(pokers[i] + ";");
		}
		// 调用pokers函数
		print(pokers);
		System.out.println();
		System.out.println("===========洗牌=========");
		// 创建随机对象
		Random random = new Random();

		// 循环 + 随机交换元素 ==> 打乱效果
		for (int i = 0; i < pokers.length; i++) {
			int r = random.nextInt(52);
			int temp = pokers[i];
			pokers[i] = pokers[r];
			pokers[r] = temp;

		}
		// 调用pokers函数
		print(pokers);

		System.out.println("\n========发牌01========");

		int[] player0 = new int[13];
		int[] player1 = new int[13];
		int[] player2 = new int[13];
		int[] player3 = new int[13];
		for (int i = 0; i < pokers.length; i++) {
			
			
			switch (i / 13) {
			case 0:
				player0[i % 13] = pokers[i];
				break;
			case 1:
				player1[i % 13] = pokers[i];
				break;
			case 2:
				player2[i % 13] = pokers[i];
				break;
			case 3:
				player3[i % 13] = pokers[i];
				break;
			}

		}
		System.out.print("============玩家手中的牌===========");
		print(player0);
		print(player1);
		print(player2);
		print(player3);
		
		
		System.out.println("\n========发牌（优化）========");
		
		int[][]players = new int[4][13];
		for (int i = 0; i < pokers.length; i++) {
			int index = i /13 ;//计算发牌到第几个玩家  ==》0~3
			int number = i %13 ;//计算发到第几张牌 ==> 0~12
			players[index][number] = pokers[i];
		}
		System.out.println("=========玩家手中的牌=========");
		System.out.println(pokers.length);
		for (int i = 0; i < pokers.length; i++) {
			System.out.println("i="+i);
			int[] player = players[i];
			print(player);
		}
		
		
		System.out.println("\n============整牌===========");
		for(int i = 0 ;i <players[0].length-1; i++) {
			//   冒泡排序
			//如果当前牌大于下一张牌
			if(players[0][i]>players[0][i+1]) {
				int temp = players[0][i];
				players[0][i] = players[0][i+1];
				players[0][i+1] = temp;
			}
		}
	}
	
	
	/*
	 * 打印扑克牌的函数（pokers） 函数的调用
	 */
	public static void print(int[] pokers) {
		System.out.println();
		System.out.println("===========打印扑克牌===========");
		String[] pNumbers = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", };
		String[] pColors = { "♠", "♥", "♣", "♦" };

		//

		for (int i = 0; i < pokers.length; i++) {
			int number = pokers[i] % 13;// 牌的颜色 0~12
			int color = pokers[i] / 13;// 牌的花色 0~3取整
			String pName = pColors[color] + pNumbers[number];
			System.out.print(pName + ",");
		}

	}
}