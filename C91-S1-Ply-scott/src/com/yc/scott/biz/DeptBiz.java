package com.yc.scott.biz;

import java.sql.SQLException;

import com.yc.scott.dao.DeptDao;

public class DeptBiz {
	
	private DeptDao ddao = new DeptDao();
	
	public int create(String deptno, String dname, String loc) throws BizException {
		// 业务逻辑 : 参数的校验, 数据的检查
		if(deptno==null || deptno.trim().isEmpty()) {
			throw new BizException("请输入部门编号!");
		}
		if(dname==null || dname.trim().isEmpty()) {
			throw new BizException("请输入部门名称!");
		}
		try {
			int count = ddao.countByDname(dname);
			if(count > 0) {
				throw new BizException("该部门已经存在!");
			}
			return ddao.insert(deptno, dname, loc);
		} catch (SQLException e) {
			// 异常转型  ==> 不同的逻辑层, 抛出对应异常
			throw new BizException("系统内部错误,请练习管理员!", e);
		}
		
	}

}
