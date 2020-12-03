package com.yc.javaee.d1203.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解
 */
/**
 * 注解的注解
 * @Target 用于定义该注解 写的位置
 * ElementType.TYPE 该注解只能加在类上
 * ElementType.FIELD 该注解只能加在属性上
 * ElementType.METHOD 该注解只能加在方法上
 */
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
/**
 * 保持性注解
 * 	默认情况下，注解只会在源代码有效（SOURCE）
 * 	RUNTIME 表示在运行时能够被反射机制访问
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 继承性注解 
 * 在默认情况下，父类的注解并不会被子类继承，如果要继承，就必须加上Inherited注解 。
 */
@Inherited
public @interface MyTest {
	
	/**
	 * 注解属性定义
	 * 
	 * default 表示该注解属性默认值，定义了默认值的属性，可以省略值的设置
	 */
	String name() default "123";
	
	/**
	 * 数组类型的注解属性，如果只赋值一个元素值，那么可以使用单值语法
	 * @return
	 */
	String[] type() default "123";
	
	/**
	 * 注解里面的 value 属性是该注解的默认属性
	 * 默认属性：如果你只定义一个属性值，并且该属性名就是 value ，那么value的名字可以不写
	 * 例如： @WebServlet( "/web.s" )
	 * @return
	 */
	String value() default "321";
	

}
