package com.yc.java.d0626;

public class Demo3 {
	
	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal("凯特","白色");
		Animal a3 = new Animal("旺财","黄色");
		// 构造函数不能使用 对象名. 执行
		// a.Animal();
		
		System.out.println(a1.getName());
		System.out.println(a1.getColor());
		System.out.println(a2.getName());
		System.out.println(a2.getColor());
		System.out.println(a3.getName());
		System.out.println(a3.getColor());
	
		
	}

}

/**
 *	构造方法(分娩对象的方法) :  
 *	1. 就是在创建对象时执行的方法, 必须在 new 后面执行
 *	2.一个对象的构造方法只能执行一次
 *	3.构造方法如果没有定义, 这系统会自动提供一个无参数的构造方法 
 *
 *	定义的特性:
 *	1. 与类名一致
 *	2. 没有返回值
 */
class Animal {
	
	// 使用构造函数对对象进行初始化
	Animal() {
		System.out.println("Animal的构造方法1");
		this.name = "汤姆";
		this.color = "蓝色";
	}
	
	// 再写一个构造函数 构造函数重载
	Animal(String name, String color){
		System.out.println("Animal的构造方法2");
		this.name = name;
		this.color = color;
	}
	
	private String name;
	private String color;
	
	void speak() {
		
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}
	
	// 扩展: 请定义性别: 雌雄 公母
	// 定义: 三个参数的构造函数, 初始化三个属性值

}
