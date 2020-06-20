package com.yc.java.d0620;

import java.util.Random;

public class Poker {
	public static void main(String args[]) {

		/**
		 * 	 扑克需求分析
		 * 	1. 打印一整副牌
		 * 	2. 洗牌( Random 随机对象  伪随机 ==> 人工智能)
		 * 	3. 发牌
		 * 	4. 整牌( 排序 ==> 冒泡排序 )
		 * 	5. 找牌,找黑桃3 => 出牌
		 * 	
		 * 	java 方法( 函数 )定义
		 * 
		 * 	实现: 54张牌  ==> 去掉2张王  => 52  => 每个花色 13 牌
		 * 
		 * 	用数字表示 牌号 0 ~ 51 表示 52张牌
		 */
		// 创建52张扑克牌
		int[] pokers = new int[52];

		// 给扑克牌赋值
		for (int i = 0; i < pokers.length; i++) {
			// 将 i 值 赋值给当前数组元素
			pokers[i] = i;
			System.out.print(pokers[i] + ", ");
		}

		// 执行函数, 将 pokers 传入到函数
		print(pokers);

		System.out.print("\n=========洗牌========");
		// 创建随机对象
		Random random = new Random();
		// 循环 + 随机交换元素 ==> 打乱效果
		for (int i = 0; i < pokers.length; i++) {
			// 随机产生被交换元素的下标值
			int r = random.nextInt(52);
			// 数组元素的交换
			int temp = pokers[i];
			pokers[i] = pokers[r];
			pokers[r] = temp;
		}
		print(pokers);

		System.out.print("\n=========发牌========");
		// 使用数组存放4个玩家的牌
		// int[] player0 = new int[13]; // 第1个玩家的牌
		// int[] player1 = new int[13]; // 第2个玩家的牌
		// int[] player2 = new int[13]; // 第3个玩家的牌
		// int[] player3 = new int[13]; // 第4个玩家的牌

		// 定义玩家的二维数组
		// int[][] players = { player0, player1, player2, player3 };
		// 上面的写法简化成功 一行代码
		int[][] players = new int[4][13];

		for (int i = 0; i < pokers.length; i++) {
			int index = i / 13; // 计算第几个玩家 ==> 0~3
			int number = i % 13; // 计算发到第几张牌 ==> 0~12
			players[index][number] = pokers[i];
		}

		System.out.print("\n=========打印玩家手中的牌========");
		// print(player0);
		// print(player1);
		// print(player2);
		// print(player3);
		for (int i = 0; i < players.length; i++) {
			int[] player = players[i];
			print(player);
		}

		/**
		 * 整牌就是将玩家手中的牌排序:   按照 :黑红梅方 => 牌号大小从小到大
		 */
		// 先对第一个玩家的牌排序( 冒泡排序 )
		// players[0]; => 一位数组 length = 13
		System.out.print("\n=========整牌========");
		
		//sort(players[0]);
		//sort(players[1]);
		//sort(players[2]);
		//sort(players[3]);
		
		for (int i = 0; i < players.length; i++) {
			int[] player = players[i];
			// 先对玩家排序
			sort(player);
			// 再打印玩家手中的牌
			print(player);
		}

	}

	/**
	 * 	打印扑克牌的函数(方法)
	 * @param pokers  函数的参数(形参)
	 */
	public static void print(int[] pokers) {
		System.out.println("\n=========打印扑克牌========");
		String[] pNumbers = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] pColors = { "黑桃", "红桃", "梅花", "方片" };
		// 打印poker
		// pokers cannot be resolved to a variable
		// pokers 未定义
		for (int i = 0; i < pokers.length; i++) {
			int number = pokers[i] % 13; // 牌的数字 0~12
			int color = pokers[i] / 13; // 牌的花色 0~3 取整
			// switch or if 90 分 100使用数组替代 switch 或 if
			String pName = pColors[color] + pNumbers[number];
			System.out.print(pName + ", ");
		}
	}

	/**
	 * 	排序
	 * @param player
	 */
	public static void sort(int[] player) {
		for (int j = 0; j < player.length - 1; j++) {
			for (int i = 0; i < player.length - 1 - j; i++) {
				// 如果当前牌大于下一张牌
				if (player[i] > player[i + 1]) {
					// 则交换两张牌
					int temp = player[i];
					player[i] = player[i + 1];
					player[i + 1] = temp;
				}
			}
		}
	}

}
