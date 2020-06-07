package com.yc.java.d0607;

public class Demo4 {

	public static void main(String[] args) {
		System.out.println("==========打印 10 个* 号==========");
		// 打印 10 个* 号
		for (int i = 0; i < 10; i++) {
			System.out.print("*"); // 不换行打印
		}
		System.out.println();

		// 使用* 打出一个矩形(矩阵) 横向 10个*,纵向 10个*
		// 双层 for 循环 ==> 嵌套循环
		System.out.println("==========使用* 打出一个矩形(矩阵)==========");
		for (int i = 0; i < 10; i++) {
			// Duplicate local variable i
			// 重复的 局部 变量 i
			// 在局部代码块中, 变量名不能重复
			for (int j = 0; j < 10; j++) {
				System.out.print("* "); // 不换行打印
			}
			System.out.println();// 换行
		}

		/**
		 *  海盗旗
		 */
		System.out.println("==========海盗旗==========");
		for (int i = 0; i < 10; i++) {
			// j 的最大值
			for (int j = 0; j < i + 1; j++) {
				System.out.print("* ");
			}
			System.out.println(); // 换行
		}
		
		/**
		 *      *
		 *    * *
		 *  * * *
		 ** * * *
		 * 反打海盗旗, 每行前面的空格也需要循环打印
		 * 
		 * 伪代码
		 * for() {
		 * 	  for(){}  // 打印一行前面的空格
		 * 	  for(){}  // 打印一行后面的星号
		 * }
		 */
		System.out.println("==========反打海盗旗==========");
		for( int i = 0 ; i < 4 ; i++) {
			for( int j = 0 ; j < 4 - i - 1 ; j++) {
				System.out.print("  ");
			}
			for (int j = 0 ; j < i + 1 ; j ++) {
				System.out.print("* ");
			}
			System.out.println();
			/**
			 *    *     3 + 1 = 4
			 *   **     2 + 2 = 4
			 *  ***     1 + 3 = 4
			 * ****     0 + 4 = 4
			 */
		}
		
		System.out.println("==========金字塔==========");
		/**
		 *   *		3 + 1
		 *  *** 	2 + 3
		 * *****	1 + 5
		 ******** 	0 + 7
		 */
		for(int i=0; i<10 ; i++) {
			// 空格打印与反打海盗旗一样, 完全复制
			for( int j = 0 ; j < 10 - i - 1 ; j++) {
				System.out.print(" ");
			}
			for( int j = 0 ; j < i * 2 + 1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/**
		 * 扩展练习
		 *    *******
		 *     *****
		 *      *** 
		 *       *
		 * 
		 *       *
		 *      *** 
		 *     *****
		 *    *******
		 *     *****
		 *      *** 
		 *       *
		 *
		 *       *
		 *      * * 
		 *     *   *
		 *    *     *
		 *     *   *
		 *      * * 
		 *       *
		 */
		
		//for(    ; /*没有退出循环的条件, 不是语法错*/ ;    ) {
			// 死循环  无限制的循环下去
		//}

	}

}
