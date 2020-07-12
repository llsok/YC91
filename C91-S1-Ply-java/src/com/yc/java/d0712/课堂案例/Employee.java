package com.yc.java.d0712.课堂案例;

/**
 * Employee类中包含三个属性和一个方法，
 * 	属性为name,basic和address,方法为show用于显示这些属性的值
 */
public class Employee {
	
	private String name;
	private double basic;
	private String address;
	
	// 自动生成的带参数的构造函数
	public Employee(String name, double basic, String address) {
		super();
		this.name = name;
		this.basic = basic;
		this.address = address;
	}



	public void show() {
		System.out.println("姓名:" + name);
		System.out.println("基本底薪:" + basic);
		System.out.println("地址:" + address);
	}

}
