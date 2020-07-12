package com.yc.java.d0712.课堂案例;

/**
 * Implicit super constructor Employee() is undefined for default constructor. 
 * Must define an explicit constructor
 */
public class Manager extends Employee {
	
	private String department;
	
	Manager( String name, double basic, String address,String department){
		super(name, basic, address);
		this.department = department;
	}
	
	public void show() {
		super.show(); // 调用父类show 方法, 显示父类3个属性
		System.out.println("部门: " + department);
	}

}
