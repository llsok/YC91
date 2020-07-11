package com.yc.java.d0711;

public class Teacher extends Person {
	
	// 属性扩展 : 薪酬
	double sal;
	// 覆盖父类的属性
	int height = 180;
	
	// 教学的行为
	public void teach() {
		System.out.println("开心的教书");
	}
	
	// 这是覆盖的方法
	public void eat() {
		System.out.println("老师在吃东西");
	}
}
