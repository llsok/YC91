package com.yc.scott.bean;

import java.sql.Timestamp;

/**
 *	定义岗位调整的实体类
 */
public class JobChange implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer empno;
	private String oldjob;
	private String newjob;
	private Float oldsal;
	private Float newsal;
	private String cause;
	private Timestamp createtime;
	private Integer allow;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getOldjob() {
		return oldjob;
	}

	public void setOldjob(String oldjob) {
		this.oldjob = oldjob;
	}

	public String getNewjob() {
		return newjob;
	}

	public void setNewjob(String newjob) {
		this.newjob = newjob;
	}

	public Float getOldsal() {
		return oldsal;
	}

	public void setOldsal(Float oldsal) {
		this.oldsal = oldsal;
	}

	public Float getNewsal() {
		return newsal;
	}

	public void setNewsal(Float newsal) {
		this.newsal = newsal;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Integer getAllow() {
		return allow;
	}

	public void setAllow(Integer allow) {
		this.allow = allow;
	}

	@Override
	public String toString() {
		return "JobChange [id=" + id + ", empno=" + empno + ", oldjob=" + oldjob + ", newjob=" + newjob + ", oldsal="
				+ oldsal + ", newsal=" + newsal + ", cause=" + cause + ", createtime=" + createtime + ", allow=" + allow
				+ "]";
	}

}
/**
-- Create table
create table JOB_CHANGE
(
  id         NUMBER(10) not null,
  empno      NUMBER(10),
  oldjob     VARCHAR2(50),
  newjob     VARCHAR2(50),
  oldsal     FLOAT,
  newsal     FLOAT,
  cause      VARCHAR2(500),
  createtime TIMESTAMP(6) default sysdate,
  allow      NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table JOB_CHANGE
  add constraint PK_JC_ID primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
 */
