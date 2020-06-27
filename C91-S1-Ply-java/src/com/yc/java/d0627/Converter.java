package com.yc.java.d0627;

public class Converter {

	// 换算因子
	private double aConversionFactor;

	// @param aConversionFactor 换算为目标单位时所使用的换算因子
	public Converter(double aConversionFactor) {
		this.aConversionFactor = aConversionFactor;
	}

	// @param fromMeasurement 度量值（单位：米）
	// @return 换算为目标单位的输入值
	public double convertTo(double fromMeasurement) {
		return fromMeasurement / aConversionFactor;
	}
}