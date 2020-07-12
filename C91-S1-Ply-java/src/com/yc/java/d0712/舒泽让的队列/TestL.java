package com.yc.java.d0712.舒泽让的队列;

public class TestL {

	public static void main(String[] args) {
		Line l=new Line();
		
		l.push(10);
		l.push(11);
		l.push(12);
		//l.push(13);
		//l.push(14);
		l.size();
		
		l.nullor();
		
		System.out.println("该队列中的首元素为："+l.Firstone());
		System.out.println("应该是10，实际是："+l.pop());
		System.out.println("应该是11，实际是："+l.pop());
		System.out.println("该队列中的首元素为："+l.Firstone());
		l.size();
		System.out.println("应该是12，实际是："+l.pop());
		System.out.println("应该是13，实际是："+l.pop());
		System.out.println("应该是14，实际是："+l.pop());
	}
}
