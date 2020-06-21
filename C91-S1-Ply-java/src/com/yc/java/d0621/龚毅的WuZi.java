package com.yc.java.d0621;

import java.util.Scanner;

public class 龚毅的WuZi {
	public static void main(String[] args) {
		/*
		 * int 的二维数组表示棋盘，没有棋子用0表示，黑1，白2
		 */
		int[][] board = new int[16][16];
		Scanner sc = new Scanner(System.in);
		
		int color =1;
		
		while (true) {
		print(board);
		System.out.print("请输入棋子的X坐标：");
		int x = sc.nextInt();
		System.out.print("请输入棋子的Y坐标：");
		int y = sc.nextInt();
		if(board[y][x]==0) {
		board[y][x] = color;
		
		boolean isWin = checkHeng(board,x,y);
		if(isWin) {
			print(board);
			System.out.println((color == 1? "黑子" : "白子")+"赢了");
			break;
		}
		boolean Win = checkShu(board,x,y);
		if(Win) {
			print(board);
			System.out.println((color == 1? "黑子" : "白子")+"赢了");
			break;
		}
		boolean xWin = checkXie(board,x,y);
		if(xWin) {
			print(board);
			System.out.println((color == 1? "黑子" : "白子")+"赢了");
			break;
		}
		color = color == 1 ? 2 : 1;
		}else {
			System.out.println("下过的位置不能再下子");
		}
		}
	}
	public static boolean checkHeng( int[][] board, int x, int y ) {
		boolean ret = false;
		int xx = x;
		int yy = y;
		int count = 1;
		
		while ( xx - 1 >= 0 ) {
			if(board[yy][xx] == board[yy][xx-1]) {
				count ++;
				xx --;
			}else {
				break;
			}
		}
		
		xx = x;
		while ( xx + 1 < board.length ) {
			if(board[yy][xx] == board[yy][xx+1]) {
				count ++;
				xx ++;
			}else {
				break;
			}
		}
		ret = count >= 5;
		return ret;
		
	}
	public static boolean checkShu( int[][] board, int x, int y ) {
		boolean ret = false;
		int xx = x;
		int yy = y;
		int count = 1;
		
		while ( yy - 1 >= 0 ) {
			if(board[yy][xx] == board[yy-1][xx]) {
				count ++;
				yy --;
			}else {
				break;
			}
		}
		
		yy = y;
		while ( yy + 1 < board.length ) {
			if(board[yy][xx] == board[yy+1][xx]) {
				count ++;
				yy ++;
			}else {
				break;
			}
		}
		ret = count >= 5;
		return ret;
		
	}
	public static boolean checkXie( int[][] board, int x, int y ) {
		boolean ret = false;
		int xx = x;
		int yy = y;
		int count = 1;
		
		while ( yy - 1 >= 0 && xx - 1 >= 0 ) {
			if(board[yy][xx] == board[yy-1][xx-1]) {
				count ++;
				yy --;
				xx --;
			}else {
				break;
			}
		}
		
		yy = y;
		xx = x;
		while ( yy + 1 < board.length && xx + 1 < board.length) {
			if(board[yy][xx] == board[yy+1][xx+1]) {
				count ++;
				yy ++;
				xx ++;
			}else {
				break;
			}
		}
		ret = count >= 5;
		return ret;
		
	}
	

	
	public static void print( int[][] board  ) {
		System.out.println("==========打印棋盘=========");
		char[] items = {'+','@','O'};
		System.out.print("   ");
		for(int i =0 ; i< board.length;i++) {
			System.out.print(i);
			if(i<=9) {
				System.out.print(" ");
			}
		}
		System.out.println();
		for(int i =0 ; i< board.length;i++) {
			System.out.print(i+" ");
			if(i<=9) {
				System.out.print(" ");
			}
			for(int j = 0; j<board[i].length;j++) {
				int value = board[i][j];
				char cvalue = items[value];
				System.out.print(cvalue+" ");
			}
			System.out.println();
		}
	}

}
