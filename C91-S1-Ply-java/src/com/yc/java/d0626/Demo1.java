package com.yc.java.d0626;

public class Demo1 {

	public static void main(String[] args) {
		// 创建对象的语法是 new 语法
		Person p1 = new Person();
		p1.name = "武松";
		p1.gender = '男';
		System.out.println(p1.name);
		System.out.println(p1.gender);
		p1.eat();

		Person p2 = new Person();
		p2.name = "扈三娘";
		p2.gender = '女';
		System.out.println(p2.name);
		System.out.println(p2.gender);
		p2.eat();

	}

}

/**
 * 	定义类的语法 
 * [ 访问修饰符 (可选) ] class 类名字 {}
 * 
 */
// 人的类
class Person {
	// 人名 字符串
	String name; // 使用变量表示属性
	char gender; // 性别

	// 行为: 使用java的方法来表示
	/**
	 *  [访问修饰符 (可选)] 返回值类型(如果没有就是 void) 方法名( 参数列表){
	 *  	方法体
	 *  }
	 */
	void eat() {
		System.out.println(name + "在吃东西!");
	}
	
	/**
	 * 	请扩展
	 * 		 定义 人的身高和体重的属性
	 * 		定义"玩"的行为	
	 */
}
