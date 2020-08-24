package com.yc.scott.bean;

/**
 * 部门表实体类 ==> 数据库 dept表
 *
 */
public class Dept {
	
	private int deptno;
	
	private String dname;
	
	private String loc;
	
	// 无参数的构造方法, 必须要定义 ==> JavaBean 规范
	public Dept() {}
	
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
