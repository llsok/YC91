package com.yc.java.d0714;

public class Demo4 {

}

class Base {
	public void method() {
		System.out.print("Base method");
	}
}

class Child extends Base {
	public void methodB() {
		System.out.print("Child methodB");

	}
}

class Sample {
	public static void main(String[] args) {
		Base base = new Child();
		// base.methodB(); // 报错
		
		
		// 解决方案1
		Child child = (Child)base; // 父类 => 子类
		child.methodB();
		
		// 解决方案2
		((Child)base).methodB();
		
	}
}
