package com.yc.java.d0712.课堂案例;

public class Director extends Employee {

	private double transportAllowance;

	public Director(String name, double basic, String address, double transportAllowance) {
		super(name, basic, address);
		this.transportAllowance = transportAllowance;
	}

	public void show() {
		super.show(); // 调用父类show 方法, 显示父类3个属性
		System.out.println("津贴: " + transportAllowance);
	}
	
}
