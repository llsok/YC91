package com.yc.java.d0808;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo2 {

	public static void main(String[] args) {

		// Set 集合: 无序不重复

		Set<String> set = new HashSet<>();

		set.add("武松");
		set.add("林冲");
		set.add("宋江");
		set.add("张青");

		set.add("宋江");
		set.add("武松");

		// set 没有 get 方法, 但是可以使用增强 for 循环
		for (String name : set) {
			System.out.println(name);
		}
		System.out.println(set);

		// set 的迭代器循环 ( list 也可以用)
		// 所有的集合都是实现迭代器接口,
		// 该接口可以用于集合变量的所有元素
		Iterator<String> it = set.iterator();
		// while 循环的迭代器写法
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// for 循环的迭代器写法
		for (Iterator<String> it1 = set.iterator(); it1.hasNext();) {
			System.out.println(it1.next());
		}
	}

}
