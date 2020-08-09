package com.yc.java.d0806;

import java.util.Arrays;

public class ExerciseString2 {

	/**
		手机号码前三位代表运营商
	  	中国电信	2G/3G号段：133，153， 180，181，189
				4G号段：173， 177
	  	中国联通	2G/3G号段：130，131，132，155，156，185，186
				3G上网卡：145
				4G号段：176，185
	  	中国移动	2G/3G号段：134，135，136，137，138，139，150，151，152，158，159，182，183，184
				3G上网卡：147
				4G号段：178，184
		请根据传入的电话号码, 返回对应的运营商的名称
		13800001111
	 */
	public String getISP(String phoneNumber) {
		String[] p1 = { "133", "153", " 180", "181", "189", "173", "177" };
		String[] p2 = { "130", "131", "132", "155", "156", "185", "186", "145", "176", "185" };
		String[] p3 = { "178", "184", "147", "134", "135", "136", "137", "138", "139", "150", "151", "152", "158",
				"159", "182", "183", "184" };
		// 获取手机号码前三位
		String prefix = phoneNumber.substring(0, 3);
		// 排序
		Arrays.sort(p1);
		Arrays.sort(p2);
		Arrays.sort(p3);
		// 查找
		if (Arrays.binarySearch(p1, prefix) >= 0) {
			return "中国电信";
		} else if (Arrays.binarySearch(p2, prefix) >= 0) {
			return "中国联通";
		} else if (Arrays.binarySearch(p3, prefix) >= 0) {
			return "中国移动";
		} else {
			return "非法的手机号码";
		}
	}

	/**
		身份证号码规则：
			前1、2位数字表示：所在省份的代码；
			第3、4位数字表示：所在城市的代码；
			第5、6位数字表示：所在区县的代码；
			第7-14位数字表示：出生年、月、日；
			第15、16位数字表示：所在地的派出所的代码；
			第17位数字表示性别：奇数表示男性，偶数表示女性；
			第18位数字是校检码
		任意给出一个身份证号码，在控制台输所有的出个人信息
			身份证: 43040320000101203X
			省份的代码: 43
			城市的代码: 04
			县区的代码: 03
			生日: 2000年01月01日
			派出所的代码: 20
			性别: 男
			校验码: X
	 */
	public void parseId(String id) {
		System.out.println("身份证: " + id);
		String s1 = id.substring(0, 2);
		String s2 = id.substring(2, 4);
		String s3 = id.substring(4, 6);

		String s4 = id.substring(6, 10);
		String s5 = id.substring(10, 12);
		String s6 = id.substring(12, 14);

		String s7 = id.substring(14, 16);
		String s8 = id.substring(16, 17);
		String s9 = id.substring(17, 18);

		Integer i = Integer.valueOf(s8);
		s8 = i % 2 == 0 ? "女" : "男";
		
		System.out.println("省份的代码: " + s1);
		System.out.println("城市的代码: " + s2);
		System.out.println("县区的代码: " + s3);
		System.out.println("生日: " + s4 + "年" + s5 + "月" + s6 + "日");
		System.out.println("派出所的代码: " + s7);
		System.out.println("性别: " + s8);
		System.out.println("校验码: " + s9);

	}

	/**
		研究网络上垃圾邮件的信息和词，请将经常在垃圾邮件中看到的30个词创建成一个列表。写一个方法，用户输入email信息，
		扫描这些词是否出现在这个邮件中，只要在信息中出现一次这些单词，就给这个词记一分，根据最后的得分，给这个邮件记一个等级，
		返回该邮件的等级
	 * @param email
	 */
	public int checkJunkMail(String email) {
		return 0;
	}

	public static void main(String[] args) {
		ExerciseString2 es2 = new ExerciseString2();
		System.out.println(es2.getISP("13800001111"));
		System.out.println(es2.getISP("15300001111"));
		System.out.println(es2.getISP("15700001111"));
		System.out.println(es2.getISP("17700001111"));
		
		es2.parseId("43040320000101203X");
	}

}
