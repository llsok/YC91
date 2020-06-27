package com.yc.java.d0627;

/**
 * 
7、写一个类Person,包含以下属性：
	String name; 
	int age; 
	String gender;   
	Person partner。
为Person类写一个marry(Person  p)方法，代表当前对象和p结婚，
如若可以结婚，则输出恭贺信息，否则输出不能结婚原因。
要求在另外一个类中写一个主方法，来测试以上程序。
（下列情况不能结婚：
	1，同性； 
	2，未达到结婚年龄，男<24，女<22；
	3，某一方已婚） *
 */
public class Demo3 {

	public static void main(String[] args) {
		Person wusong = new Person("武松", 30, "男", null);
		Person wangying = new Person("王英", 32, "男", null);
		Person husanniang = new Person("扈三娘", 22, "女", wangying);
		Person lishishi = new Person("李师师", 25, "女", null);
		Person yatoujia = new Person("丫头甲", 22, "女", null);
		
		wusong.marry(wangying);
		wusong.marry(husanniang);
		wusong.marry(lishishi);
		wusong.marry(yatoujia);
	}

}

// 人类
class Person {

	private String name;
	private int age;
	private String gender; // 性别
	private Person partner; // 配偶

	Person(String name, int age, String gender, Person partner) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.partner = partner;
	}

	/**
	 * 	结婚方法
	 * @param p 和p结婚，
	 */
	public void marry(Person p) {
		// 同性
		if (this.gender == p.gender) {
			System.out.println("同性不婚");
			return;
		}

		// 未达到结婚年龄，男<24，女<22；
		if (this.gender == "男" && this.age < 24 || this.gender == "女" && this.age < 22) {
			System.out.println("我的结婚年龄不够");
			return;
		}
		if (p.gender == "男" && p.age < 24 || p.gender == "女" && p.age < 22) {
			System.out.println("你的结婚年龄不够");
			return;
		}

		// 某一方已婚
		if (this.partner != null || p.partner != null) {
			System.out.println("某一方已婚");
			return;
		}
		
		// 我的配置赋值为 p
		this.partner = p;
		// p 的配置赋值为 我
		p.partner = this;
		
		// printf 格式化打印, 可以避免字符串边界, 语法格式参考 C 语言
		System.out.printf("祝愿%s和%s白头偕老!!!\n", this.name, p.name);
	}
}
