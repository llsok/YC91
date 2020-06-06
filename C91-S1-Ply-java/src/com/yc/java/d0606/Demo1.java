package com.yc.java.d0606;

public class Demo1 {

	public static void main(String[] args) {

		int a = 80;

		String s = a > 90 ? "优秀" : "良好";

		System.out.println(s);

		System.out.println("====================");

		if (a >= 90) {
			System.out.println("成绩优秀");
		}

		if (a >= 80 && a < 90) {
			System.out.println("成绩良好");
		}

		System.out.println("====================");

		if (a >= 90) {
			System.out.println("成绩优秀");
		} else { // else 表示 ! ( a>=90 ) ==> a < 90
			if (a >= 80) {
				System.out.println("成绩良好");
			}
		}

		System.out.println("====================");
		if (a >= 90) {
			System.out.println("成绩优秀");
		} else if (a >= 80) {
			System.out.println("成绩良好");
		} else if (a > 60) {
			System.out.println("成绩及格");
		} else {
			System.out.println("成绩不及格");
		}
		
	}

}
