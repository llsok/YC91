package com.yc.java.d0712;

public class Demo3 {

	public static void main(String[] args) {
		D d = new D();
		d.test();  // 100 or 200 ?
	}
	
}

// The type A is already defined
// A 类已经定义了

class E {
	int c = 300;
}


class C extends E{
	int c = 100;
}

class D extends C {
	int c = 200;
	
	void  test() {
		System.out.println(super.c);
	}
}