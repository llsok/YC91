package com.yc.java.d0714;

// 导入java 工具包下的随机类
import java.util.Random;

/**
 *	 实际上多态包括:
 *		动态多态(重写)  ==> 必须有继承
 *		静态多态(重载) 
 */
public class Demo2 {

	public static void main(String[] args) {

		// 两个 add 方法 是重载方法 ==> 也是多态 ==> 静态多态

		add(1, 2); // ==> 3  1,2 字面值 整数==> 默认的整数类型是 int
		add("1", "2"); // ==> 12  // "" 就表示了字符串的类型
		
		/**
		 *  在编译器编译前, 编译器就已经知道要调用哪个方法
		 *  这种多态就叫 静态多态
		 *  
		 *  在编译器编译后,在执行方法时, 才知道调用的是哪个对象的方法
		 *  这种多态就叫 动态多态
		 */

		speak(getAnimal());
		speak(getAnimal());
		speak(getAnimal());
		speak(getAnimal());
		speak(getAnimal());
		speak(getAnimal());
		speak(getAnimal());
	}
	
	/**
	 * 	随机创建一个动物
	 */
	static Animal getAnimal() {
		// 创建一个随机对象
		Random random = new Random();
		// 随机生成 0 和 1
		if(random.nextInt(2) == 0) {
			return new Dog();
		} else {
			return new Cat();
		}
	}
	
	static void speak(Animal a) {
		/**
		 * 在编译器编译后,在执行方法时, 才知道调用的是哪个方法
		 *  这种多态就叫 动态多态
		 */
		a.speak();
	}

	static int add(int a, int b) {
		return a + b;
	}

	static String add(String a, String b) {
		return a + b;
	}

}
