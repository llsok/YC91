package com.yc.java.d0714;

public class Demo5 {
	public static void main(String[] args) {

		ClassA p0 = new ClassA();
		ClassB pl = new ClassB();
		ClassC p2 = new ClassC();
		ClassA p3 = new ClassB();
		ClassA p4 = new ClassC();

		p0 = pl;  // 子 转 符    直接转
		//pl = p2;  // 父 转 子  要强转
		//p2 = p4;  // 父 转 子  要强转
		//p2 = (ClassC) pl;  // 子 转 子  永远错
		pl = (ClassB) p3;
		p2 = (ClassC) p4;

	}

}

class ClassA {
}

class ClassB extends ClassA {
}

class ClassC extends ClassA {
}
