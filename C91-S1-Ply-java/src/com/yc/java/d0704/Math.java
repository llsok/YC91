package com.yc.java.d0704;

public class Math {
	// 构造函数同样可以重载
	
	Math(){}
	Math(int a){}
	Math(float a) {}

	int add(int a, int b) {
		return a + b;
	}
	
	// Duplicate method add(int, int) in type Math
	//  重复的              方法    
	/*int add(int b, int a) {
		return a + b;
	}*/
	
	// 参数个数不同
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	// 类型不同
	float add(float a, float b) {
		return a + b;
	}
	
	
	// 顺序不同
	float add(int a, float b) {
		return a + b;
	}
	// 顺序不同
	float add(float a, int b) {
		return a + b;
	}
	
	// 重载不关注返回值
	void add(double a, double b) {
		
	}
	
	
	// 多 个 add 函数构成了 方法重载 

	public static void main(String[] args) {
		Math m = new Math();
		int a = 1;
		int b = 2;
		System.out.println(m.add(a, b));
		
		float f1 = 1.5f;
		float f2 = 2.5f;
		
		/**
		 * The method add(int, int) in the type 
		 * Math is not applicable for the arguments (float, float)
		 *  重载:
		 *  在一个类中, 出现方法名相同, 而参数不同的情况, 叫方法重载
		 *  参数不同:
		 *  	1. 参数的类型不同
		 *  	2. 参数的个数不同
		 *  	3. 参数的顺序不同
		 *  
		 *  重载的注意:
		 *  	1. 参数名不影响重载
		 *  	2. 方法名必须完全一致(大小写一致)
		 *  	3. 返回值不影响重载
		 *  	4. 构造函数同样可以重载
		 *  
		 *  	5. 请勿将功能完全不一样的方法进行重载！   业务的要求, 不是语法的规则
		 *  	int add (byte a, byte b){
		 *  		return a - b;   // 语法完全正确, 语义错误
		 *  	}
		 *  
		 *  	int sub (byte a, byte b){
		 *  		return a - b;  
		 *  	}
		 *  
		 *  
		 */
		System.out.println(m.add(f1, f2));
		
		System.out.println(m.add(100, 200, 300));
		
		
		A a1 = new A();
		a1.name = "武松";
		a1.play();
		
		A a2 = new A();
		a2.name = "李逵";
		a2.play();
	}
	
}


class  A {
	
	String name;
	int age;
	
	void play() {
		
		//this.name; // ==>a1.name;
		//this.play(); // ==> a1.play();
		System.out.println(name + "开心的玩");
	}
	
}


















