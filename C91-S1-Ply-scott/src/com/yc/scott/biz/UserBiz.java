package com.yc.scott.biz;

import java.sql.SQLException;
import java.util.Map;

import com.yc.scott.dao.UserDao;

public class UserBiz {

	private UserDao udao = new UserDao();

	/**
	 * 登录方法
	 * 
	 * @param name
	 * @param pwd
	 */
	public boolean login(String name, String pwd) {

		// 对用输入参数判断 : 参数校验
		if (name == null || name.trim().isEmpty()) {
			// 提示方法调用者, 这个出错了 ==> 抛出一个业务异常
			/**
			 * 未完待续 ...
			 */
		}

		Map<String, Object> emp;
		try {
			// 调用 dao 方法
			emp = udao.selectByLogin(name, pwd);
			// 判断结果
			return emp != null;
		} catch (SQLException e) {
			// SQL 只能从 dao 抛出, 不能再从biz 抛出
			// 不用逻辑层抛出不同异常
			// dao ==> SQL ==> SQLException
			// biz ==> 业务逻辑 ==> 自定义的业务异常
			/**
			 * 未完待续 ...
			 */
			return false;
		}

	}

}
