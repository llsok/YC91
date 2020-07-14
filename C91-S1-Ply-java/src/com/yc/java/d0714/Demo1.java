package com.yc.java.d0714;

public class Demo1 {
	
	public static void main(String[] args) {
		
		Animal a = null;
		Animal b = null;
		Animal c = null;
		
		// ...省略 N 行代码	...
		//a = new Animal();
		//b = new Animal();
		a = new Dog(); // 父类变量名引用子类的对象
		b = new Cat(); // 父类引用子类对象  ==> 引用转型
		
		a.speak();  // 汪,汪,汪
		b.speak();  // 喵,喵,喵
		/**
		 * 扩展
		 */
		c.speak();  // 咩,咩,咩
		
		// 多态: 同一个类型的对象, 表现出不同行为
		// 人妖: ==> 多态性
		/**
		 * 1. 继承
		 * 2. 重写
		 * 3.父类引用子类对象
		 */
	}

}

// 动物类
class Animal {
	
	void speak() {
		System.out.println("动物的叫声");
	}
	
}

class Dog extends Animal{
	void speak() {
		System.out.println("汪,汪,汪");
	}
}

class Cat extends Animal{
	void speak() {
		System.out.println("喵,喵,喵");
	}
}

