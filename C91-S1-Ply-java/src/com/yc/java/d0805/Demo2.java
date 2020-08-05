package com.yc.java.d0805;

public class Demo2 {
	/**
	 * try 关键字必须出现, 并且只能出现 1 次
	 * catch 可以出现 0 到 N 次
	 * finally 可以出现 0 到 1次
	 * catch 和 finally 两个必须出现其中一个, 或者两个同时都出现
	 */
	public static void main(String[] args) {

		try {
			System.out.println("开始执行!");
			a();
			// 没有catch 表示不捕获异常, 异常仍然会导致程序终止
		} finally {
			System.out.println("执行结束!");
		}

	}

	public static void test2() {
		try {
			System.out.println("开始执行!");
			a();
			// System.out.println("执行结束!");
		} catch (RuntimeException e) {
			// 父类可以捕获子类的异常
			// 如果父类异常定义在子类异常的上面,
			// 会导致子类异常无法捕获到异常对象, 从而导致语法错误
			e.printStackTrace();
			System.out.println("运行时异常, 执行出错!");

			// Unreachable catch block for NullPointerException.
			// It is already handled by the catch block for RuntimeException
			// RuntimeException 已经处理该异常
			/*		} catch (NullPointerException e) {
						e.printStackTrace();
						System.out.println("空指针异常, 执行出错!");
					} catch (ArithmeticException e) {
						// 异常被捕获到, 一般都要打印方法栈
						e.printStackTrace();
						System.out.println("除0异常, 执行出错!");*/

		} finally {
			// 时表示: 不管有没有出现错误 finally 都一定会执行
			// finally 一般用于关闭一些资源, 如: 文件, 数据库的连接 ....
			System.out.println("执行结束!");
		}
	}

	public static void test1() {
		try {
			System.out.println("开始执行!");
			a();
			// System.out.println("执行结束!");
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("空指针异常, 执行出错!");
		} catch (ArithmeticException e) {
			// 异常被捕获到, 一般都要打印方法栈
			e.printStackTrace();
			System.out.println("除0异常, 执行出错!");
		} finally {
			// 时表示: 不管有没有出现错误 finally 都一定会执行
			// finally 一般用于关闭一些资源, 如: 文件, 数据库的连接 ....
			System.out.println("执行结束!");
		}
	}

	public static void a() {
		System.out.println("====== a =====");
		b();
		// int[] a = {};
		// System.out.println(a[0]);
	}

	public static void b() {
		System.out.println("====== b =====");
		c();
		// int i = 1 / 0;
	}

	public static void c() {
		System.out.println("====== c =====");
		Object o = null;
		// Object o = new Object();
		o.toString();
	}
}
