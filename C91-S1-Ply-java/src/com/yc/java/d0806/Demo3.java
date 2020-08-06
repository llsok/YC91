package com.yc.java.d0806;

public class Demo3 {
	
	public static void main(String[] args) {
		
		Object a = new Object();
		// 任何继承于Object的子类, 如果没有重写equals方法
		// 那么 equals 就等效于 ==
		// String 的 equals 是被重写的
		a.equals(1);
		
		Object b = new Integer(100);
		Object c = "123";  // String
		Object d = 100;	   // 100 => Integer装箱 ==> Object
		
		// getClass 获取 类对象
		System.out.println("======= 获取对象实际类型 getClass =======");
		System.out.println(a.getClass());
		System.out.println(b.getClass());
		System.out.println(c.getClass());
		System.out.println(d.getClass());
		
		System.out.println("======= toString 输出对象的字符串形式的值 =======");
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		
		Person p = new Person("武松",35);
		System.out.println(p.toString());
		System.out.println(p);
		
		System.out.println("======= 自定义对象的对比  =======");
		Person p1 = new Person("武松",35);
		System.out.println(p == p1);
		System.out.println(p.equals(p1));
		
	}

}

class Person {
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
	 * 返回 对象 的哈希码的方法
	 * 一般情况下要求要同时重写 ==> 集合有关
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}





