package com.yc.java.d0718;

public class Demo {
	
	public static void main(String[] args) {
		
		// 接口的使用与抽象类一样
		Plane p1 = new Copter();
		Plane p2 = new Jet();
		
		p1.fly();
		p1.addOil();
		
		p2.fly();
		p2.addOil();
	}

}

/**
 * 	请定义  父类  plane 飞机接口:   fly(飞行, 抽象) ,   addOil (加油  非抽象方法)
 * 	子类 : Copter  直升飞机
 * 		Jet   喷气机
 * 
 * 	使用接口方式实现
 */
/*抽象类实现
abstract class Plane {
	abstract void fly();
	void addOil() {
		
	}
}*/

// 接口中的方法一定都是抽象方法, 
// java语法规定接口中抽象法可以省略 abstract
interface Plane {
	// 接口中的方法默认都是 public 作用域
	void fly();
	void addOil();
}

class Copter implements Plane {
	// Cannot reduce the visibility of the 
	// inherited method from Plane
	// 定义的方法不能降低可见性
	public void fly() {
		System.out.println("垂直飞行");
	}
	
	public void addOil() {
		System.out.println("加油");
	}
}

class Jet implements Plane {
	public void fly() {
		System.out.println("喷气飞行");
	}
	
	public void addOil() {
		System.out.println("加油");
	}
}







