package com.yc.java.d0807;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo1 {

	public static void main(String[] args) {

		Date d1 = new Date(); // 当前时间
		System.out.println(d1);

		// 废弃的构造函数, 不建议使用, java有可能在未来的某个版本中删除该函数
		Date d2 = new Date(2020 - 1900, 7, 7); //
		System.out.println(d2);

		// 使用时间戳创建日期: 时间戳是 1970.1.1 到现在的毫秒值
		Date d3 = new Date(120455454);
		System.out.println(d3);
		// getTime 获取日期的时间戳
		System.out.println(d3.getTime());
		System.out.println(d1.getTime());

		// 日期 减去 1天的毫秒值
		d1.setTime(d1.getTime() - 1000 * 60 * 60 * 24 * 30);
		System.out.println(d1);
		/**
		 * 扩展练习
		 * after
		 * before
		 */

		System.out.println("======= Calendar =========");
		// 给日期减少一月
		/**
		 * Date 只是用于保存一个时间点(时间戳, 毫秒值)
		 * Calendar 日历对象实现对日期的计算
		 * 		使用 getInstance() 创建日历对象
		 * 		新创建的日历对象, 内部保存了一个Date对象
		 */
		Calendar c = Calendar.getInstance(); // ctrl + 1
		/**
		 * Calendar.getTime 返回的是 Date 类型的对象
		 * Date.getTime		返回的是 时间戳( 毫秒值 )
		 */
		Date d4 = c.getTime();
		long time = d4.getTime();
		System.out.println(d4);
		System.out.println(time);

		/**
		 * Calendar 提供一些的运算日期的方法
		 * add	是在当前时间上加上或减去某个时间字段值, 并且加减会影响相邻字段
		 * 		add( 字段标志值,  加减值   )
		 * 		2020-07-07 12:30:40
		 * 		加30天 ==> 2020-08-06 12:30:40
		 * 
		 * roll	是在当前时间上加上或减去某个时间字段值, 并且加减会不影响相邻字段
		 * 		roll( 字段标志值,  加减值   )
		 * 		2020-07-07 12:30:40
		 * 		加30天 ==> 2020-07-06 12:30:40
		 * set  直接给某个字段设置日期值, 替换原有值
		 */
		System.out.println("======== add and roll ==========");
		System.out.println(new Date());
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, 30);
		System.out.println(c.getTime());
		// 恢复日历的时间为当前时间
		c.setTime(new Date());
		c.roll(Calendar.DAY_OF_MONTH, 30);
		System.out.println(c.getTime());

		c.set(Calendar.MONTH, 11); // 0 是 1月
		System.out.println(c.getTime());

		// SimpleDateFormat 日期格式化工具
		// 不是java.util包的类, 是java.text下类
		/**
		 *  构建时要输入掩码
		 *  y 表示年
		 *  M 月
		 *  d 号,天
		 *  H 24小时制的小时
		 *  h 12小时制的小时
		 *  m 分钟  ( oracle : mi)
		 *  s 秒
		 */
		String mask = "yyyy年MM月dd日 HH时mm分ss秒";
		SimpleDateFormat sdf = new SimpleDateFormat(mask);
		// format 是将日期转成字符串
		String dateString = sdf.format(c.getTime());
		System.out.println(dateString);
		// parse 将字符串转成日期
		try {
			Date d5 = sdf.parse("2000年08月07日 20时15分42秒");
			System.out.println(d5);
			//ParseException 是编译期异常, 必须捕获
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
