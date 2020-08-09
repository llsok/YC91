package com.yc.java.d0809;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo3 {

	public static void main(String[] args) {
		/**
		 * 输出:  程序 => 文件(程序外)
		 * 输入:  文件(程序外) => 程序
		 * 
		 * 流的分类和命名:
		 * 出入方向分:  
		 * 	输入流: 类名中带 Input 或 Reader
		 * 	输出流: 类名中带 Output 或 Writer
		 *读写数据的格式分:
		 *	字节流: 类名中带 Stream
		 *		jpg, gif, MP3, avi  二进制数据 0,1
		 *		以字节单位读写文件
		 *	字符流: 类名中带 Reader 或 Writer
		 *		txt, xml, html 文字信息
		 *		以字符单位读写文件
		 *处理的对象
		 *	资源流: 读文件, 读内存, 读网络 流对象在构建时会传入被处理的资源名( 例如:文件)
		 *	处理流: 处理另外一个流的数据, 流对象在构建时会传入另外一个流
		 * 
		 */

		// 将hello world 写入文件
		// 1. 操作的是字符还是字节: Reader 或 Writer 或 Stream ==> Reader 或 Writer
		// 2.出入方向: Reader 或 Writer 或 Input 或 Output ==> Writer
		// 3.目的是什么: File ==> FileWriter
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:/temp/a.txt");
			fw.append("hello world");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		FileWriter fw = null;
		try {
			// 创建流
			fw = new FileWriter("d:/temp/a.txt");
			// 输出字符串(数据)
			fw.append("hello world");
			//Thread.sleep(1000* 60); // 休眠一分钟
		} catch (IOException e) {
			// 读写文件产生的异常
			e.printStackTrace();
		//} catch (InterruptedException e) {
			// 休眠产生异常
			//e.printStackTrace();
		} finally {
			// 流用完之后必须关闭, 如果不关闭, 那么该文件会一直处于被
			// 打开的状态, 那么其他程序将无法操作该文件
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/

		/**
		 * 读取文件
		 */
		FileReader fr = null;
		try {
			fr = new FileReader("d:/temp/a.txt");
			// 读入的字符数组
			char[] buffer = new char[1024];
			// count 存放读入的字符数
			int count = fr.read(buffer);
			String text = new String(buffer, 0, count);
			System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
