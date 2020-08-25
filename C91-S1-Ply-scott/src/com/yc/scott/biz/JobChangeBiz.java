package com.yc.scott.biz;

import java.sql.SQLException;

import com.yc.scott.bean.JobChange;
import com.yc.scott.dao.DeptDao;
import com.yc.scott.dao.JobChangeDao;
import com.yc.scott.dao.UserDao;

public class JobChangeBiz {
	
	private JobChangeDao jdao = new JobChangeDao();
	// EmpDao
	private UserDao udao = new UserDao();
	
	/**
	 * 复杂的数据操作, 包括 2次 修改数据库的操作
	 * 		insert into job_change ...
	 * 		update emp ...
	 * 	必须是用 事务管理机制
	 * @param jc
	 * @return
	 * @throws BizException
	 */
	public void create(JobChange jc) throws BizException {
		// 业务逻辑 : 参数的校验, 数据的检查
		if(jc.getOldjob()==null || jc.getOldjob().trim().isEmpty()) {
			throw new BizException("请输原职位!");
		}
		if(jc.getNewjob()==null || jc.getNewjob().trim().isEmpty()) {
			throw new BizException("请输入新职位!");
		}
		try {
			jdao.insert(jc);
		} catch (SQLException e) {
			// 异常转型  ==> 不同的逻辑层, 抛出对应异常
			throw new BizException("系统内部错误,请联系管理员!", e);
		}
		
	}

}
