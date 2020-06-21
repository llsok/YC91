package com.yc.java.d0621;

public class Demo1 {

	public static void main(String[] args) {
		int num = 0, count = 0;
		for (int i = 0; i <= 100; i++) {
			num += i;
			count = count++;
		}
		System.out.println(num + count + "" + (num * count));
	}

}
