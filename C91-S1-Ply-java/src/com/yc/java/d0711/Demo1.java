package com.yc.java.d0711;

public class Demo1 {

	public static void main(String[] args) {

		Student s = new Student();
		Teacher t = new Teacher();

		s.age = 18;
		s.name = "武松";
		s.eat();
		System.out.println("学生的身高" + s.height);
		/**
		 * 	扩展的属性和方法
		 */
		s.sn = "123456";
		s.study();
		// s.teach(); teach 是老师的方法

		t.age = 80;
		t.name = "周侗";
		t.eat(); // 方法同样可以被继承
		System.out.println("老师的身高" + t.height);
		/**
		 * 	扩展的属性和方法
		 */
		t.sal = 50000;
		t.teach();
		// t.sn sn 是学生的属性(学号)

		// The field Person.pwd is not visible 不可见( 私有 )
		// s.pwd = "";

	}

}
