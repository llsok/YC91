package com.yc.java.d0621;

import java.util.Scanner;

/**
 * 五子棋
 */
public class WuZhi {

	public static void main(String[] args) {
		/**
		 * int的二维数组表示棋盘, 没有棋子用 0 表示, 黑子用1表示, 白子用2表示
		 * 0 => +
		 * 1 => @
		 * 2 => O 
		 */
		int[][] board = new int[16][16];
		Scanner sc = new Scanner(System.in);
		int color = 1; // 初始棋子颜色

		while (true) {
			print(board);
			System.out.print("请输入棋子的X坐标: ");
			int x = sc.nextInt();
			System.out.print("请输入棋子的Y坐标: ");
			int y = sc.nextInt();
			/**
			 * 扩展点    下过的位置不能再下子
			 */
			if (board[y][x] == 0) {
				// 通过 x,y 设置 棋盘上的棋子
				board[y][x] = color;

				/**
				 * 判断横向五子是否成功
				 */
				boolean isWin = checkHeng(board, x, y);
				/**
				 * 请参考 checkHeng 方法, 编写竖向的判断  checkShu
				 */
				if (isWin) {
					print(board);
					System.out.println((color == 1 ? "黑子" : "白子") + "赢了!");
					break;
				}
				// 切换黑白子 三元表达式
				color = color == 1 ? 2 : 1;

			} else {
				System.out.println("下过的位置不能再下子!");
			}
		}
	}

	/**
	 * 判断横向的五子是否成立
	 * 分析:
	 * 	假设 下子的位置是    x=5,y=5
	 * 	横向的判断  左边是 4,5   3,5
	 * 	横向的判断  左边是 6,5   7,5
	 * 
	 * @param board 棋盘的二维数组
	 * @param x 当前下的子的 x 坐标
	 * @param y 当前下的子的 y 坐标
	 * @return 五指成立返回 true, 否返回 false
	 */
	public static boolean checkHeng(int[][] board, int x, int y) {
		// 定义返回值
		boolean ret = false;
		// 定义用于计算的 x 和 y
		int xx = x;
		int yy = y;
		// 定义子数
		int count = 1;

		// 判断左边的同色的子数
		while (xx - 1 >= 0) {
			// 左边的子和当前的子颜色时候一样
			if (board[yy][xx] == board[yy][xx - 1]) {
				// 子数加一
				count++;
				// 当前x坐标左移一位
				xx--;
			} else {
				// 颜色不一样那么就退出循环
				break;
			}
		}
		// 判断右边的同色的子数
		// 回复 xx 的值,重新判断右边
		xx = x;
		while (xx + 1 < board.length) {
			// 右边的子和当前的子颜色时候一样
			if (board[yy][xx] == board[yy][xx + 1]) {
				// 子数加一
				count++;
				// 当前x坐标左移一位
				xx++;
			} else {
				// 颜色不一样那么就退出循环
				break;
			}
		}
		// 加总左边两边的子数
		// 判断是否大于等于5
		ret = count >= 5;
		return ret;
	}

	/**
	 * 打印棋盘
	 * @param board
	 */
	public static void print(int[][] board) {
		System.out.println("=======打印棋盘========");
		char[] items = { '+', '@', 'O' };
		// 遍历二维数组的第一维数组
		System.out.print("   ");
		for (int i = 0; i < board.length; i++) {
			System.out.print(i);
			if (i <= 9) {
				System.out.print(" ");
			}
		}
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + " ");
			if (i <= 9) {
				System.out.print(" ");
			}
			// 对二维数组内部的一维数组遍历
			for (int j = 0; j < board[i].length; j++) {
				int value = board[i][j];
				// 根据 value 的值(0,1,2) 获取对应的显示的字符, 替代switch
				char cvalue = items[value];
				System.out.print(cvalue + " ");
			}
			System.out.println();
		}
	}

}
