package com.yc.bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bbs.bean.UserBean;
import com.yc.common.util.DBHelper;
import com.yc.common.util.DBHelper.ResultSetMapper;

public class LoginDao {

	public List<UserBean> Login(String uname,String upass) throws SQLException{
		String sql="select * from tbl_user where uname=? and upass=?";
		
		DBHelper dbh=new DBHelper();
		return dbh.selectList(sql, new ResultSetMapper<UserBean>() {

			@Override
			public UserBean map(ResultSet rs) throws SQLException {
				UserBean ub=new UserBean();
				ub.setUname(rs.getString("uname"));
				ub.setUpass(rs.getString("upass"));
				ub.setId(rs.getInt("id"));
				ub.setHead(rs.getString("head"));
				return ub;
			}
		
		}, uname,upass);
	}
}
