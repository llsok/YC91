package com.yc.java.d0811;

import java.util.Arrays;
import java.util.Collections;

public class Demo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// b();
		try {
			d();
		} catch (MyException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());  
		}
		
	}

	public static void a() {
		int i = 1 / 0;  // 产生 数学异常 ==> java 虚拟机产生
	}

	public static void b() {
		try {
			a(); // 运行期异常
		} catch (Exception e) {
			e.printStackTrace();  // 打印异常
			throw e;    // 抛出异常
		}
	}
	
	/**
	 * 编译期异常从方法抛出必须声明, 使用 throws 关键字
	 */
	public static void c() throws MyException {
		// 自定义异常不能由虚拟产生, 是用户自己创建
		throw new MyException("这是我定义的异常, 没什么业务含义");
	}
	
	public static void d() throws MyException {
		c();  //不处理编译期异常对导致编译错误 , 继续抛出
	}

}

/**
 * 自定义的编译期异常   自动生成异常的代码
 */
class MyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}



/**
 * 自定义的运行期异常   自动生成异常的代码
 */
class MyException1 extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyException1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException1(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyException1(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyException1(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyException1(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}












