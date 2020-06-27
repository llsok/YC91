package com.yc.java.d0627;

/**
 * 1、实现一个具有以下特性的Car类。一辆汽车有一定的燃油效率
	(测量单位可以是英里/千米)并且油箱中有一定的油量。
	效率在构造函数中确定，初始油量为0.提供一个drive()
	方法模拟汽车行驶一定的距离并减少油箱油量。
	再提供一个返回当前油量的getGas方法和一个用于加油的
	addGas方法。用法示例如下:
	Car myHybrid=new Car(49);
	myHybrid.addGas(20);
	myHybrid.drive(100);
	System.out.println(myHybrid.getGas());
 */
public class Demo1 {

	public static void main(String[] args) {
		Car myHybrid = new Car(49);
		myHybrid.addGas(20);
		myHybrid.drive(100);
		System.out.println(myHybrid.getGas());
	}

}

// Car 类

class Car {

	// 油量 gas
	private int gas;
	// 耗油率 rate
	private int rate;

	// 构造方法
	Car(int rate) {
		this.rate = rate;
	}

	// 加油
	void addGas(int gas) {
		this.gas += gas;
	}

	/**
	 * 	行驶
	 * @param num 公里数
	 */
	void drive(int num) {
		// 计算消耗油量
		int size = num / rate;
		// 计算剩余油量
		gas -= size;
	}

	// 返回当前油量
	public int getGas() {
		return gas;
	}
}
