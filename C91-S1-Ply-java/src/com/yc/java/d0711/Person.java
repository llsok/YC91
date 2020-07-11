package com.yc.java.d0711;

public class Person {
	String name;
	int age;
	
	int height = 100;
	
	
	// 私有属性, 子类不会继承
	private String pwd;  
	//吃
	public void eat() {
		System.out.println("人类在吃饭");
	}
}
