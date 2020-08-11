package com.yc.java.d0811;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import com.yc.util.IOHelper;

/**
 * 瞩目助手
 */
public class Zhumu {

	// 学生集合
	private LinkedHashSet<String> stuSet = new LinkedHashSet<>();
	// 回复的学生
	private LinkedHashSet<String> replySet = new LinkedHashSet<>();
	// 定义问题时间
	private String qTimeStr;

	private File meetingFile;

	public static void main(String[] args) {
		Zhumu zm = new Zhumu();
		zm.init("吴夏翘,阳晶任,吴宗术,张亚楠,龚毅,张钰婷,张韬,朱炅锋,金嘉慧,易帆,蒋卓航,杨天烨,贺子超,舒泽让,关彤,李志勇,钟浣文,许如愿,金鹏,杨强,王红玉");
		zm.setMeetingFile("C:\\Users\\Administrator\\Documents\\zhumu\\2020-08-11 07.57.24 廖彦个人会议室 1362863660"
				+ "\\meeting_saved_chat.txt");
		System.out.println(zm.stuSet);
		System.out.println(zm.meetingFile);
		// 设置问题时间
		zm.setqTimeStr("2020-08-11 11:20:27");
		zm.parse();
		zm.count();
	}

	/**
	 * 导入所有的学生
	 * @param students
	 */
	public void init(String students) {
		// 字符串拆分数组 split
		String[] stus = students.split(",");
		init(stus);
	}

	public void init(String[] students) {
		// 数组转为集合 ? ==> Set 无序不重复 ==> LinkedHashSet 有序不重复
		// 数组转List
		List<String> sList = Arrays.asList(students);
		// 集合对象添加另一个集合对象中的所有元素
		stuSet.addAll(sList);
	}

	/**
	 * 设置瞩目的聊天文件
	 * @param meetingFile
	 */
	public void setMeetingFile(String meetingPath) {
		meetingFile = new File(meetingPath);
		if (meetingFile.exists() == false) {
			System.out.println("文件不存在!");
			meetingFile = null;
		}
	}

	/**
	 * 分析聊天记录内容
	 * 分析回复的人数, 扫描所有的回复记录, 根据人名, 将回复的人名记录在一个set集合中
	 */
	public void parse() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			// 读入文件 资源流
			fr = new FileReader(meetingFile);
			// 以行方式读取, 处理流 BufferedReader
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				// 解析每行中人名 正则表达式
				// 08:57:12 廖彦 : swt
				// .+? \n+ .+? \s:\s .+
				if (line.matches(".+?\\s+.+?\\s:\\s.+")) {
					/**
					 * 判断当前行是否要被过滤
					 */
					if (filter(line)) {
						continue;
					}
					// 提取行中的人名
					String name = line.replaceAll(".+?\\s+(.+?)\\s:\\s.+", "$1");
					/**
					 * 提取人名中的汉字 (复杂) ==> 剔除人名中符号和数字字母  \\w 字母数字_
					 */
					name = name.replaceAll("[\\w-\\s]", "");
					// 记录到set集合
					replySet.add(name);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源流就可以了
			IOHelper.close(fr); // 减少代码冗余
		}
	}

	// 设置问题的时间
	public void setqTimeStr(String qTimeStr) {
		this.qTimeStr = qTimeStr;
	}
	/**
	 * 判断当前行是否要被过滤
	 * @param line
	 * @return
	 */
	private boolean filter(String line) {
		SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date qDate = ymdhms.parse(qTimeStr);
			// 从回复行中截取时分秒
			String hmsStr = line.replaceAll("(.+?)\\s+.+?\\s:\\s.+", "$1");
			// 从问题时间中截取年月日
			String ymdStr = qTimeStr.substring(0, 11);
			Date rDate = ymdhms.parse(ymdStr + hmsStr);
			// 判断 qDate 是否在 rDate 之后
			// qDate.after(rDate);
			// 判断 rDate 是否在 qDate 之前
			return rDate.before(qDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 统计回复结果
	 */
	public void count() {
		System.out.println("回复人数" + replySet.size() + " : " + replySet);
		// 挂机人数 从 学生set 中 排除已经回复的学生
		LinkedHashSet<String> stuSet = new LinkedHashSet<>();
		// 将实例变量stuSet的元素, 添加到局部变量stuSet 中
		stuSet.addAll(this.stuSet);
		stuSet.removeAll(replySet);
		System.out.println("挂机人数" + stuSet.size() + " : " + stuSet);
		// 扩展: 统计访客人数
		// replySet + stuSet 加总 到一个新的 set 中
		// 排除 stuSet 剩下就是访客
		System.out.println("访客人数??? : ???");
	}

}
