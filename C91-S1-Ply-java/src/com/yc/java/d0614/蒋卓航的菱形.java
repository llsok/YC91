package com.yc.java.d0614;

public class 蒋卓航的菱形 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" *");
			}
			System.out.println();

		}
		System.out.println("========打印空心菱形========");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				if (j == 0 || j == 2 * i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * (4 - i) - 1; j++) {
				if (j == 0 || j == 2 * (4 - i) - 2) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}
}