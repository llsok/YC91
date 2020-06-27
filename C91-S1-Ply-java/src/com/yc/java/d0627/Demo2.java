package com.yc.java.d0627;

/**
 * 
3、编写一个程序，提示用户输入一个以米为单位的度量值，
然后将其换算为英里数、英尺数和英寸数。使用下面的类:
public class Converter{
	 //@param aConversionFactor 换算为目标单位时所使用的换算因子
	 public Converter(double aConversionFactor){…}
	 //@param  fromMeasurement 度量值（单位：米）
	 //@return 换算为目标单位的输入值
	 public double convertTo(double fromMeasurement){…}
}
构造3个与下例类似的实例:
   final double MILE_TO_KM=1.609;  // Java常量定义
   Converter milesToMeters=new Converter(1000*MILE_TO_KM);
 */
public class Demo2 {

	// alt + / ==> 选择
	public static void main(String[] args) {
		final double MILE_TO_KM = 1.609; // Java常量定义
		// 创建一个 米转英里的转换器
		System.out.println("================英里转换器===============");
		Converter milesToMeters = new Converter(1000 * MILE_TO_KM);
		System.out.println("1000米=" + milesToMeters.convertTo(1000) + "英里");
		System.out.println("3000米=" + milesToMeters.convertTo(3000) + "英里");
		System.out.println("8000米=" + milesToMeters.convertTo(8000) + "英里");
		
		System.out.println("================英尺转换器===============");
		Converter milesToYingChi = new Converter(0.3048);
		System.out.println("1米=" + milesToYingChi.convertTo(1) + "英尺");
		System.out.println("3米=" + milesToYingChi.convertTo(3) + "英尺");
		System.out.println("8米=" + milesToYingChi.convertTo(8) + "英尺");
		
		System.out.println("================英寸转换器===============");
		// 扩展英寸转换器
	}

}
