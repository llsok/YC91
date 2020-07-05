package com.yc.java.d0705;

/**
 * 	块 : 类中定义的没有名字块  ( 代码块   方法, 函数  )
 * 	静态块
 *
 */
public class Demo1 {
	
	{
		// 这就是一个代码块
		// 当前这是一个类的动态的代码块, 它会在该类构造方法前执行
		System.out.println("    动态的代码块      ");
	}
	
	static {
		// 当前这是一个类的静态的代码块
		System.out.println("    静态的代码块      ");
	}

	Demo1(){
		System.out.println("    构造方法      ");
	}
	
	void test () {
		// 有名称的代码块
	}
	
	public static void main(String[] args) {
		
		Demo1 d1 = new Demo1();
		
		Demo1 d2 = new Demo1();
		
		Demo1 d3 = new Demo1();
		
		
	}
	
	static void test1() {
		
	}

}
