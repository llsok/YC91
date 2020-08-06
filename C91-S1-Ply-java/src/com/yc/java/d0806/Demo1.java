package com.yc.java.d0806;

public class Demo1 {
	
	public static void main(String[] args) {
		int a = 1;
		Integer A = new Integer(a);
		byte a1 = A.byteValue();
		System.out.println(a1);
		// The static field Integer.MAX_VALUE
		// 这个   静态              属性(字段) Integer.MAX_VALUE
		// should be accessed in a static way
		// 要通过静态的方式进行访问
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		String str = "100";		
		Byte objByte = Byte.valueOf(str);  // 解析
	    Short objShort = Short.valueOf(str);
	    Integer objInt = Integer.valueOf(str);
	    Long objLong = Long.valueOf(str);

	    System.out.println(objByte);
	    System.out.println(objShort);
	    System.out.println(objInt);
	    System.out.println(objLong);
	    
	    str = "116";
	    //分别调用各个包装类的paseXxx方法对字符串进行转换，如果转换失败，将报异常
	    int i = Integer.parseInt(str);
	    short s = Short.parseShort(str);
	    byte b = Byte.parseByte(str);
	    long l = Long.parseLong(str);
	    float f = Float.parseFloat(str);
	    double d = Double.parseDouble(str);
	    System.out.println(i);
	    System.out.println(s);
	    System.out.println(b);
	    System.out.println(l);
	    System.out.println(f);
	    System.out.println(d);

	    char c = 'A';
	    Character C = new Character(c);
	    
	    System.out.println(Character.isDigit(c));
	    System.out.println(Character.isLetter(c));
	    
	    
	    
	    // 自动拆装箱
	    float z = 0.1f;
	    Float Z = new Float(0.1f);
	    // java 1.5 之后可以直接赋值 => 自动装箱
	    Z = z; // 自动装箱
	    z = Z;   // 自动拆箱
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
	}

}
