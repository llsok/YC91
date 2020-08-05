package com.yc.java.d0805;

public class Demo1 {

	public static void main(String[] args) {
		a();
		b();
		c(null);
	}

	public static void a() {
		try {
			// 被监控的代码块
			System.out.println("=====a=====");
			int[] a = { 1, 2, 3 };
			System.out.println(a[0]);
			System.out.println(a[1]);
			System.out.println(a[2]);
			// 数据越界
			// 由系统自动产生一个异常对象,
			// 该对象包含了异常发生处所有信息
			// Array Index Out Of Bounds Exception: 4
			// at com.yc.java.d0805.Demo1.a(Demo1.java:20)
			// at com.yc.java.d0805.Demo1.main(Demo1.java:6)
			// 方法调用栈
			System.out.println(a[4]);
			System.out.println("======a=======");
		} catch ( Exception e) { // 被监控异常对象声明
			
			// ctrl + 鼠标点击 ==> 查看源代码
			
			// 获取异常信息
			System.out.println("异常信息: " + e.getMessage());
			// 获取异常原因异常, 一个异常导致另一异常
			// 那么该异常就是另一个异常原因异常
			System.out.println("原因异常: " + e.getCause());
			// 打印异常方法调用栈
			e.printStackTrace();

			// 处理异常的代码
			System.out.println("访问的数组元素不存在!");
		}

	}

	public static void b() {
		System.out.println("=====b=====");
		// 除0异常
		int a = 1 / 0;
	}

	public static void c(Object obj) {
		System.out.println("=====c=====");
		System.out.println(obj);
		// 输出obj对象 哈希码 这里会出现大名鼎鼎的空指针异常
		System.out.println(obj.hashCode());
	}

}
