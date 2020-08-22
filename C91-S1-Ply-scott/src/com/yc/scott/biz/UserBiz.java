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
	 * @throws BizException 
	 */
	public boolean login(String name, String pwd) throws BizException {

		// 对用输入参数判断 : 参数校验
		if (name == null || name.trim().isEmpty()) {
			// 提示方法调用者, 这个出错了 ==> 抛出一个业务异常
			throw new BizException("请填写用户名!");
		}
		
		if (pwd == null || pwd.trim().isEmpty()) {
			throw new BizException("请填写密码!");
		}

		Map<String, Object> emp;
		try {
			// 调用 dao 方法
			emp = udao.selectByLogin(name, pwd);
			System.out.println("登录的员工信息: "+emp);
			// 判断结果
			if( emp != null) {
				return true;
			} else {
				throw new BizException("用户名或密码错误!");
			}
		} catch (SQLException e) {
			// SQL 只能从 dao 抛出, 不能再从biz 抛出
			// 不用逻辑层抛出不同异常
			// dao ==> SQL ==> SQLException
			// biz ==> 业务逻辑 ==> 自定义的业务异常
			e.printStackTrace();
			throw new BizException("系统异常,请练习管理员!", e);
		}

	}

}
