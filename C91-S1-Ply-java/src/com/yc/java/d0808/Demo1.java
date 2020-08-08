package com.yc.java.d0808;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Demo1 {

	public static void main(String[] args) {

		// 只要是 List 下面的类, 它们可以完全替代
		// ArrayList 内部使用数组存放元素 , 查询快, 插入慢 线程不安全 速度快
		// List l1 = new ArrayList();
		// LinkedList 内部使用链表存放元素 查询慢, 插入快
		// List l1 = new LinkedList();
		// 内部使用数组存放元素 线程安全 速度慢 多线程
		List<Integer> l1 = new Vector<>();

		// 泛型告警, 所有的集合都是泛型类
		// 泛型: 对集合存放元素的约束

		l1.add(5);
		l1.add(10);
		l1.add(10);

		System.out.println(l1); // 集合可以直接打印

		l1.add(1, 8);

		System.out.println(l1); // 集合可以直接打印

		// l1.remove(10); // 传 int 类型, 是根据索引值删除, 输入的值被认为是索引
		l1.remove(Integer.valueOf(10)); // 要上 10 这个数字, 必须将10 转成Integer(对象)
		System.out.println(l1); // 集合可以直接打印

		// 查找
		System.out.println(l1.indexOf(8));

		// size 获取集合长度
		for (int i = 0; i < l1.size(); i++) {
			// 获取当前索引处的对象
			System.out.println(l1.get(i));
		}

	}

}
