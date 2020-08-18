package com.yc.swt;

import java.util.Date;
import java.util.List;

/**
 * 用户信息的实体类 ( 结构体 ) ==> 传递信息(数据), 必须加上序列化接口
 * 实现步骤:
 * 1. 定义属性
 * 2. 生成getter和setter
 * 3. 生成toString()
 * 4. 实现序列化接口 + 序列化版本编号
 * 5. 生成构造方法(可选)
 */
public class UserInfo implements java.io.Serializable{

	/**
	 * 序列化版本编号, 自动生成
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String pwd;
	private char sex;
	private List<String> likes;
	private String edu;
	private int age;
	private Date birthday;
	private int score;
	
	public UserInfo() {
		// 无参构造方法, 保留
	}
	
	public UserInfo(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public List<String> getLikes() {
		return likes;
	}
	public void setLikes(List<String> likes) {
		this.likes = likes;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", likes=" + likes + ", edu=" + edu
				+ ", age=" + age + ", birthday=" + birthday + ", score=" + score + "]";
	}
	
}
