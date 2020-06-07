package com.yc.java.d0607;

public class Demo1 {

	public static void main(String[] args) {

		// 请求判断闰年: 1996, 2200
		// 1. 能被 400 整除一定闰年
		// 2. 能被4整除并且不能为100整除

		int year = 1996;

		if (year % 400 == 0) {
			System.out.println(year + "是闰年!");
		} else if (year % 4 == 0 && year % 100 != 0) {
			System.out.println(year + "是闰年!");
		} else {
			System.out.println(year + "不是闰年!");
		}

		if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
			System.out.println(year + "是闰年!");
		} else {
			System.out.println(year + "不是闰年!");
		}

		// 三元表达式 不建议这么写
		System.out.println( 
				year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ? 
						(year + "是闰年!") : (year + "不是闰年!")   );
		
		// 年份从屏幕输入, 反复的输入年份
	}

}
