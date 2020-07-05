package com.yc.java.d0705;
import com.yc.java.d0705.sub1.*;  // * 表示全部的类
public class Demo2 {
	public static void main(String[] args) {
		// 默认情况下, 当前类只能看到当前包下的类
		SubDemo1.test();
		SubDemo.test();
		Demo1.test1();
	}
}
class Demo {    }

// 一个java 文件中可以定义多个类,  这些类也是同属于当前包, 同样也不能重名
// The type Demo1 is already defined
//class Demo1 {
	
//}
