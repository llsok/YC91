package com.yc.bbs.dao;

import java.sql.SQLException;
import java.util.List;

import com.yc.common.util.DBHelper;

public class BoardDao {
	
	/**
	 * 查询所有的分类
	 * 	List<?> 如果不是用元素，可以使用?
	 * @return
	 */
	public List<?> query(){
		String sql ="SELECT\n" +
				"	a.*, b.*, c.title,\n" +
				"	c.uid,\n" +
				"	c.publishtime,\n" +
				"	d.*\n" +
				"FROM\n" +
				"	tbl_board a\n" +
				"LEFT JOIN (\n" +
				"	SELECT\n" +
				"		boardid,\n" +
				"		count(*) cnt\n" +
				"	FROM\n" +
				"		tbl_topic\n" +
				"	GROUP BY\n" +
				"		boardid\n" +
				") b ON a.id = b.boardid\n" +
				"LEFT JOIN (\n" +
				"	SELECT\n" +
				"		*\n" +
				"	FROM\n" +
				"		tbl_topic a\n" +
				"	WHERE\n" +
				"		a.id IN (\n" +
				"			SELECT\n" +
				"				MAX(id)\n" +
				"			FROM\n" +
				"				tbl_topic\n" +
				"			GROUP BY\n" +
				"				boardid\n" +
				"		)\n" +
				") c ON a.id = c.boardid\n" +
				"LEFT JOIN (\n" +
				"	SELECT\n" +
				"		*\n" +
				"	FROM\n" +
				"		tbl_user u\n" +
				"	WHERE\n" +
				"		u.id IN (\n" +
				"			SELECT\n" +
				"				uid\n" +
				"			FROM\n" +
				"				tbl_topic\n" +
				"			GROUP BY\n" +
				"				uid\n" +
				"		)\n" +
				") d ON d.id = c.uid";

		/**
		 * +
				"LEFT JOIN (\n" +
						"	SELECT\n" +
						"		*\n" +
						"	FROM\n" +
						"		tbl_user u\n" +
						"	WHERE\n" +
						"		u.id IN (\n" +
						"			SELECT\n" +
						"				uid\n" +
						"			FROM\n" +
						"				tbl_topic\n" +
						"			GROUP BY\n" +
						"				uid\n" +
						"		)\n" +
						") d ON d.id = c.uid"
		 */
		
		try {
			return DBHelper.selectListMap(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
