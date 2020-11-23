package com.yc.javaee.d1114.singer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.javaee.d1114.singer.bean.SqSinger;
import com.yc.javaee.d1114.singer.util.DBHelper;
import com.yc.javaee.d1114.singer.util.DBHelper.ResultSetMapper;

public class SqSingerDao {

	// 歌手实体对象属性映射对象
	private SqSingerMapper ssMapper = new SqSingerMapper();

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            第几页 ，从 1 开始
	 * @return
	 */
	public List<SqSinger> selectPage(int page) {
		// 计算开始页数
		int begin = (page - 1) * 10;
		// mysql 分页查询语法 ： limit 从第几行开始, 查几行数据
		String sql = "select * from sq_singer limit ?, 10";
		try {
			return DBHelper.selectList(sql, ssMapper, begin);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取总记录数
	 * @return
	 */
	public int selectCount() {
		String sql = "select count(*) cnt from sq_singer";
		try {
			List<Integer> list = DBHelper.selectList(sql, new ResultSetMapper<Integer>() {
				@Override
				public Integer map(ResultSet rs) throws SQLException {
					return rs.getInt("cnt");
				}
			});
			return list.get(0);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}

/**
 * 歌手实体对象属性映射类（因为会多次被调用，所以单独定义一个类）
 */
class SqSingerMapper implements ResultSetMapper<SqSinger> {
	@Override
	public SqSinger map(ResultSet rs) throws SQLException {
		SqSinger ss = new SqSinger();
		ss.setId(rs.getInt("id"));
		ss.setName(rs.getString("name"));
		ss.setLikes(rs.getInt("likes"));
		ss.setCategory(rs.getString("category"));
		ss.setNation(rs.getString("nation"));
		ss.setBirthday(rs.getString("birthday"));
		ss.setMembers(rs.getString("members"));
		ss.setIntro(rs.getString("intro"));
		return ss;
	}
}
