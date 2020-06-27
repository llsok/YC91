package com.yc.java.d0627;

/**
 * 
 * @author 黄程
 *	实现一个SodaCan类，它有getSurfaceArea()和getVolume()
	方法.在构造函数中，提供圆柱的高和半径.
 */
public class Q1 {
	public static void main(String[] args) {
		SodaCan sc = new SodaCan(10.0, 5);
		sc.show();
		SodaCan sc1 = new SodaCan(8, 12);
		sc1.show();
		SodaCan sc2 = new SodaCan(50, 40);
		sc2.show();
		
	}
}

class SodaCan {
	double height;
	double radius;

	SodaCan(double height, double radius) {
		this.height = height;
		this.radius = radius;
	}

	public double getSurfaceArea() {
		return 3.14 * radius * radius * 2 + 2 * 3.14 * radius * height;
	}

	public double getVolume() {
		return height * 3.14 * radius * radius;
	}

	public void show() {
		System.out.println("该圆柱的表面积为" + this.getSurfaceArea());
		System.out.println("该圆柱的体积为" + this.getVolume());

	}

}