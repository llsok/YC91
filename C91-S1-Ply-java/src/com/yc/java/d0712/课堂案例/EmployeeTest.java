package com.yc.java.d0712.课堂案例;

/**
 * 	所有类的属性通过构造方法初始化。
 */
public class EmployeeTest {
	
	public static void main(String[] args) {
		
		Manager m = new Manager("武松", 3000, "清河县", "步兵头领");
		Director d = new Director("林冲" , 5000, "开封", 500);
		
		m.show();
		d.show();
		
	}

}
