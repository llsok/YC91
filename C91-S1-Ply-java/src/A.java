// 单行注释
// ctrl + + 放大     缩小 -
// default package 默认的包
// 粗体 表示 关键字
// console 控制台
public class A {
	
	// String[] args 字符串数组 ==> args[0] 获取第一个元素
	// 运行时传入的参数
	public static void main( String[] args ) {
		// ctrl + s  保存   eclipse 会自动的编译 class 文件
		// java A 廖彦       java A
		
		// 判断是否有传入参数
		// 程序的健壮性提升  软件工程
		if ( args.length == 0 ) {
			System.out.println("hello world");
		} else {
			System.out.println("hello " + args[0]);
		}
		
		/*
		 * 多行注释
		 *
		 * 解决运行报错方法
		 * 1. 带参数运行  ==> run configuration...
		 * 2. 简单的编码, 避免报错
		 * 		使用 判断逻辑
		 * 
		 */
	}

}
