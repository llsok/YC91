package com.yc.java.d0531;

public class Demo3 {
	
	public static void main(String[] args) {
		
		System.out.println("============关系运算符============");
		// 返回结果是boolean
		boolean a = 5 > 6;
		System.out.println("a = " + a);
		
		char c1 = 'a';
		int  i1 = 97;
		a = c1 == i1;
		System.out.println("a = " + a);
		
		System.out.println("============逻辑运算符============");
		// 返回结果是boolean
		// 参与运算的也是 boolean
		// 与 & 并且      或  | 或者       非 ! 否则
		boolean c =  true  &  true;    // 与  & 两边都是 true 结果才是 true
		System.out.println("true  &  true = " + c);
		c =  true  &  false;    // 与  & 两边都是 true 结果才是 true
		c =  false  &  true;    // 与  & 两边都是 true 结果才是 true
		System.out.println("false  &  true = " + c);
		
		c = true | false;  // 或 |  两边只要有一边为 true 结果就是 true
		System.out.println("true | false = " + c);
		c = false | true;  // 或 |  两边只要有一边为 true 结果就是 true
		System.out.println("false | true = " + c);
		
		c = ! true;
		System.out.println("! true = " + c);
		c = ! false;
		System.out.println("! false = " + c);
		
		// 表达中出现多个 逻辑运算符, 那么就有优先级的问题
		// 最高级别是 ! (一元表达式), 其次是 & , 最后是 | 
		c = true & false | true;
		System.out.println("true & false | true = " + c);
		c = true | true & false;
		System.out.println("true | true & false = " + c);
		
	}

}
