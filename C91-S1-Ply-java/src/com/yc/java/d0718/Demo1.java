package com.yc.java.d0718;

public class Demo1 {
	
	public static void main(String[] args) {
		全栈工程师 a = new 全栈工程师();
		前端工程师 b = new 前端工程师();
		后端工程师 h = new 后端工程师();
		
		// 动态多态
		Java c = a;   // 全栈工程师(子类) ==> Java(父类)
		Oracle d = a;
		
		// Type mismatch: cannot convert from 前端工程师 to Oracle
		// 前端工程师 没有实现 Oracle 接口, 所以不能向上转型为 Oracle
		// Oracle e = b;
		Java f = b;
		Html g = b;
		
		Java i = h;
		Oracle j = h;
		Person k = h;
		//Html l = h;
		
	}

}

// 类 ==> 抽象类 ==> 接口 越来越抽象( 实现的代码越来越少 )

/**
 * 	到了接口, 那么对接口的定义只剩下 方法原型 
 * 		==> 接口只定义了行为名称
 * 			==> 定义能力,  理解为能力的描述
 */

interface Java {
	// 简化, 没有方法
	void java();
}

interface Oracle {
	void oracle();
}

interface Html {

}

// 全栈工程师 ==> 万精油
// java 实现多个接口的语法
class 全栈工程师 implements Java, Oracle, Html {
	public void java() {
	}

	public void oracle() {
	}
}

// 之前的写法: class 前端工程师 implements Java, Html {
class 前端工程师 implements UI {
	public void java() {
	}
}


/**
 * extends + implements 
 *
 */
//
class Person {
	String name;
	String gender;
	// ...
}

// 后端工程师 继承于 Person 实现了 java 和 oracle
class 后端工程师 extends Person implements Java, Oracle {
	public void java() {
	}

	public void oracle() {
	}
}

/**
 * 	接口是可以继承, 与类继承不同是, 接口的继承云多继承
 * 	UI 相当于   前端工程师
 * 
 * 	该语法相当于将 多个接口打成功一个 接口包
 */
interface UI extends Html,Java {
	
}


