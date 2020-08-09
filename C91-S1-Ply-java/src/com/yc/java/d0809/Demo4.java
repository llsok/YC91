package com.yc.java.d0809;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4 {

	public static void main(String[] args) {
		String src = "d:/temp/a.txt";
		String dest = "d:/temp/c.txt";
		copy(src, dest);

		src = "e:/二期项目模板.zip";
		dest = "d:/temp/二期项目模板(拷贝).zip";
		copy(src, dest);

	}

	/**
	 * 	 文件拷贝(文本, 图片, 视频) => 字节流
	 * @param src  源文件路径
	 * @param dest 目标文件路径
	 */
	public static void copy(String src, String dest) {
		// 文件字节输入流
		FileInputStream fis = null;
		// 文件字节输出流
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int count;
			// 循环的将源文件的内容写入到目标文件去
			while ((count = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, count);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(fis);
			close(fos);
		}
	}

	/**
	 * 	关闭流
	 * @param closer 流对象
	 */
	public static void close(Closeable closer) {
		if (closer != null) {
			try {
				closer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
