package com.yc.java.d0718;

// 宠物
/**
 * 	定义了抽象方法的类也必须定义抽象类
	有抽象方法的类一定是抽象类
 *
 */
public abstract class Animal {
	
	public static void main(String[] args) {
		// 抽象类不能直接被 new ( 创建 )出来
		//Animal a = new Animal();
		
		Animal a = new Dog();
		a.speak();
		
		Animal b = new Cat();
		b.speak();
	}
	
	String name;
	// 起名字
	void setName(String name) {
		this.name = name;
	}
	/**
	 * 	如何在语法上避免这种错误
		// 怎么定义动物的叫声
		// 在此编写代码实际上是错误的行为
		抽象方法不允许有方法体
	 */
	abstract void speak();

}

class Dog extends Animal {
	void speak() {
		System.out.println("汪汪汪");
	}
}

class Cat extends Animal {
	// 子类如果不是抽象类, 那么必须实现抽象方法
	void speak() {
		System.out.println("喵喵喵");
	}
}

// 如果不实现抽象方法, 那么子类必须是抽象类
abstract class Bird extends Animal {
	
}

abstract class A {
	
	
	
}


/**
 * 	请定义  父类  plane 飞机类:   fly(飞行, 抽象) ,   addOil (加油  非抽象方法)
 * 	子类 : Copter  直升飞机
 * 		Jet   喷气机
 */









