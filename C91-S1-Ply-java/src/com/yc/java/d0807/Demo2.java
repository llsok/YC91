package com.yc.java.d0807;

import java.util.Arrays;

public class Demo2 {

	public static void main(String[] args) {
		
		/**
		 * 8种基本数据类型, 和查用的比如: String, Date, 都是实现了 Comparable接口
		 * 		可以直接排序
		 */
		
		// Arrays 数组工具类: 排序, 查找
		int[] arr = { 11, 3, 45, 7, 15, 44, 26 };
		System.out.println("排序前直接打印:" + arr);
		// [   I   @15db9742
		// 数组   类型     内存地址(哈希码)  ==> 数组对象的默认的字符串输出
		System.out.println("排序前格式化后打印:" + Arrays.toString(arr));
		
		// 排序前无法查找
		System.out.println("45 在 :"+ Arrays.binarySearch(arr, 45));
		System.out.println("44 在 :"+ Arrays.binarySearch(arr, 44));
		
		// 默认使用升序排序 : 小 => 大
		Arrays.sort(arr);
		System.out.println("排序后直接打印:" + arr);
		// Arrays.toString 实现数组的格式化转换成功字符串
		System.out.println("排序后格式化后打印:" + Arrays.toString(arr));
		
		Person[] ps = {
				new Person("b武松", 35),
				new Person("v李逵", 32),
				new Person("s宋江", 38),
				new Person("a吴用", 37),
		};
		
		//ClassCastException: com.yc.java.d0807.Person
		// 类型转换错误  Integer => String
		//cannot be cast to java.lang.Comparable( 接口 )
		// Person 无法转换成功 Comparable 接口
		// 可以传入任何类型的数组, 可不可排序那就不知道了?
		// 传入 sort 方法中的数组, 其中的元素必须都是 Comparable 接口的子类, 才能个排序
		Arrays.sort(ps);
		System.out.println(Arrays.toString(ps));
		
		// binarySearch 可以查找元素
		/**
		 * 注意: binarySearch方法要求传入数组是排序后的数组
		 */
		System.out.println("45 在 :"+ Arrays.binarySearch(arr, 45));
		System.out.println("44 在 :"+ Arrays.binarySearch(arr, 44));

	}

}
/**
 * 人类
 * @author 廖彦
 * <Person> 泛型定义
 */
class Person implements Comparable <Person>{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	/**
	 * 用于将当前对象和传入的对象进行比较, 
	 * 如果比传入的要大 则返回一个大于0的整数
	 * 如果比传入的要小 则返回一个小于0的整数
	 * 如果和传入的相等 则返回0
	 */
	@Override
	public int compareTo(Person o) {
		// 假设要对年龄排序, 那么使用age进行比较
		// 升序
		// return this.age - o.age;
		// 降序
		// return o.age - this.age;
		// 使用姓名排序, 直接调用 name 的 compareTo ==> String 实现了 Comparable 接口
		return this.name.compareTo(o.name);
	}
	
}





