package com.yc.bbs.test;

import java.sql.SQLException;

import org.junit.Test;

import com.yc.bbs.dao.TopicDao;

public class CountTopicTest {

	private TopicDao dao = new TopicDao();
	@Test
	public void test() throws SQLException {

		System.out.println(dao.selectTotalByBid("5"));
		
	}

}
