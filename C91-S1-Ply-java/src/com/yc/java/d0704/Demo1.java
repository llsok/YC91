package com.yc.java.d0704;

public class Demo1 {
	
	String a;
	static String b; // 静态   b 是属于 Demo1 类的静态属性(静态成员)
	
	void test() {
		System.out.println(this.a + "------   test  -----" + b);
	}
	
	static void test1() {
		// 静态成员方法只能对类的静态成员变量进行操作  a 不是静态,说静态方法无法访问
		// 静态成员方法没有this引用     this 表示当前对象
		
		Demo1 d = new Demo1();
		// a 属于 d 对象
		System.out.println(d.a + "------   test  -----" + b);
		
	}
	
	public static void main(String[] args) {
		
		Demo1 d1 = new Demo1();
		Demo1 d2 = new Demo1();
		Demo1 d3 = new Demo1();
		System.out.println("============1==========");
		d1.a = "武松";
		// The static field Demo1.b should be accessed in a static way
		//  这个 静态            属性            Demo1.b  对其访问使用静态方式
		// 静态成员不属于某一个对象, 所以对其访问不需要使用 对象名, 
		// 使用对象名返回静态成员, 编译期将会出现上面的告警提示
		// 正确的方式:  使用类型返回静态成员  Demo1.b
		// 静态成员:  静态属性,  静态方法,   静态块,   静态类
		
		Demo1.b = "戒刀";
		System.out.println(Demo1.b); // ==>  戒刀 
		System.out.println(Demo1.b); // ==>  戒刀
		System.out.println(Demo1.b); // ==>  戒刀
		 
		d2.a = "李逵";
		d2.b = "板斧";
		System.out.println("===========2===========");
		System.out.println(d1.b); // ==>  板斧 
		System.out.println(d2.b); // ==>  板斧 
		System.out.println(d3.b); // ==>  板斧 
		
		d3.a = "林冲";
		d3.b = "长枪";
		
		System.out.println("===========3===========");
		
		System.out.println(d1.a);
		System.out.println(d1.b);
		
		System.out.println(d2.a);
		System.out.println(d2.b);
		
		System.out.println(d3.a);
		System.out.println(d3.b);
		
		System.out.println("===========4===========");
		d1.test();
		d2.test();
		d3.test();
		/**
		 * 静态方法
		 */
		// The static method test1() from the type Demo1 should be accessed in a static way
		Demo1.test1();
		
		
		
		
	}
	
	

}
