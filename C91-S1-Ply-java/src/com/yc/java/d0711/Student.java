package com.yc.java.d0711;

// Student 继承于 (extends 扩展) Person
public class Student extends Person {
	
	// 属性扩展 : 学号
	String sn;
	// 覆盖父类的属性
	int height = 200;
	
	// 学习的行为 ==> 扩展
	public void study() {
		System.out.println("开心的学习");
	}
	
	// 这是覆盖的方法
	public void eat() {
		System.out.println("学生在吃东西");
	}
}
