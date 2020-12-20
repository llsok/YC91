package com.yc.bbs.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yc.common.util.DBHelper;

public class TopicDao {

	public List<Map<String, Object>> selectByBid(String bid) throws SQLException {
		String sql = "SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	tbl_topic a\n" +
				"LEFT JOIN tbl_user b ON a.uid = b.id\n" +
				"LEFT JOIN (\n" +
				"	SELECT\n" +
				"		topicid,\n" +
				"		count(*) cnt\n" +
				"	FROM\n" +
				"		tbl_reply\n" +
				"	WHERE\n" +
				"		topicid = 1\n" +
				"	GROUP BY\n" +
				"		topicid\n" +
				") c ON a.id = c.topicid\n"
				+ " where a.boardid=?";
		return DBHelper.selectListMap(sql, bid);
	}
	
	public List<?> selectByIdWithReply(String id) throws SQLException{
		String sql = "SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	(\n" +
				"		SELECT\n" +
				"			*\n" +
				"		FROM\n" +
				"			tbl_topic\n" +
				"		WHERE\n" +
				"			id = ?\n" +
				"		UNION ALL\n" +
				"			SELECT\n" +
				"				*\n" +
				"			FROM\n" +
				"				tbl_reply\n" +
				"			WHERE\n" +
				"				topicid = ?\n" +
				"	) a\n" +
				"JOIN tbl_user b ON a.uid = b.id";
		return DBHelper.selectListMap(sql, id, id);
	}

	public void insert(String title, String content, 
			Object uid, String boardid) throws SQLException {
		String sql = "insert into tbl_topic"
				+ " values(null,?,?,now(),null,?,?)";
		DBHelper.update(sql, title,content,uid,boardid);
	}
	
	public void insertReply(String title,String content,Object uid,String topicid) throws SQLException {
		String sql = "insert into tbl_reply values(null,?,?,now(),null,?,?)";
		DBHelper.update(sql, title,content,uid,topicid);
	}

}
