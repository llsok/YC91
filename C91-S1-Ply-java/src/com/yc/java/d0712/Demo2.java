package com.yc.java.d0712;

public class Demo2 {
	public static void main(String[] args) {
		/**
		 * 	如果类没有定义构造函数, 
		 * 	那么虚拟机会自动提供一个无参数的构造函数
		 */
		Demo2 d2 = new Demo2();
		//  虚拟机不会自动提供一个无参数的构造函数
		// Point p = new Point();
		Point p = new Point(1, 2);
		
		Circle c = new Circle(2.5f); // 实例化"圆"类对象
	}
}

class Point { // 定义"点"类
	// x轴坐标和y轴坐标，由于准备用于继承，故修饰为protected
	protected float mX, mY;

	/**
	 * 	如果类有定义构造函数, 
	 * 	那么虚拟机不会自动提供一个无参数的构造函数
	 */
	public Point(float x, float y) { // 构造方法
		mX = x;
		mY = y;
	}
	
	// 自定义个以无参数的构造函数
	/*public Point() {
		
	}*/
}

class Circle extends Point { // 定义"圆"类继承于"点"类
	protected float mRadius; // 半径
	// 为什么这里会报错
	/**
	 * Implicit super constructor Point() is undefined. 
	 * Must explicitly invoke another constructor
	 * 	解决方法:
	 * 		1 或者 我们给父类定义一个无参构造函数
	 * 		2 使用 super 关键字
	 * 	super 指代父类对象, 作用类似于 this( 当前对象 )
	 */
	public Circle(float r) { // 构造方法
		// 该语句必须是子类构造方法的第一条语句。
		super(1,2);//执行父类的构造函数
		mRadius = r;
	}
}

/**
 * 
 * 	在实例化Circle类对象时，虚拟机一定会先调用其父类（Point类）的构造方法；
	Point类的构造方法需要两个参数来初始化其成员，但此时并没有获得这两个参数，
	造成Point类的构造方法无法执行；
	父类的构造方法执行失败从而导致子类（Circle类）的对象也无法创建；
	问题的关键是：在实例化子类对象时，如何将参数传递给父类的构造方法？这将使用到super关键字。
 * 
 */



// 一个类文件中只能出现一个 public 类
/*public class Demo {
	public static void main(String[] args) {
		Circle c = new Circle(2.5f); // 实例化"圆"类对象
	}
}
*/