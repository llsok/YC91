package com.yc.java.d0809;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 	java.util包
 * 	集合
 * 		单列集合: Collection
 * 			1. List 	有序可重复  有 get(index) 方法
 * 				ArrayList, LinkedList, Vector
 * 			2. Set  	无序不重复, 无 get(index) 方法
 * 				HashSet, LinkedHashSet( 有序不重复 ) , TreeSet( 排序不重复)
 * 			3. Queue	队列, 先入先出 
 * 		双列集合: Map 键值对存储, 并且无序, 键的取值是唯一的, 值的取值可以重复
 * 			HashMap, LinkedHashMap, Hashtable(线程安全), TreeMap, Properties
 * 			Set : 集合获取元素非常不方便
 * 			Map : 给Set集合中的每个元素起个名字(唯一)
 */
public class Demo1 {

	public static void main(String[] args) {
		// map的泛型是2个类型, 分别表示键值的类型
		// Map<String, String> map = new HashMap<>();
		// Map<String, String> map = new LinkedHashMap<>();
		Map<String, String> map = new TreeMap<>();
		map.put("3武松", "行者");
		System.out.println(map);
		map.put("4李逵", "黑旋风");
		System.out.println(map);
		map.put("2花荣", "小李广");
		System.out.println(map);
		map.put("6卢俊义", "玉麒麟");
		System.out.println(map);
		map.put("1武松", "打虎英雄");
		System.out.println(map);
		
		// 取值
		System.out.println(map.get("2花荣"));
		// 没有键值, 返回 null
		System.out.println(map.get("宋江"));
		
		
		// 增强 for , 要将 map 集合转换成 set 集合
		// Entry 是 Map 接口的静态内部接口
		Set<Entry<String, String>> entrySet = map.entrySet();
		for(Entry<String, String> en : entrySet ) {
			System.out.println(en.getKey() + " : " + en.getValue());
		}
		// 获取键set集合
		Set<String> set = map.keySet();
		// 获取值的集合 ==> Collection
		Collection<String> col = map.values();
		
		// 扩展, 请完成对键集合和值集合的遍历

	}

}
