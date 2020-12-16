package com.yc.bbs.biz;

import java.sql.SQLException;

import com.yc.bbs.dao.TopicDao;
import com.yc.common.biz.BizException;
import com.yc.common.util.Utils;

public class TopicBiz {

	private TopicDao tdao = new TopicDao();

	public void add(String title, String content,
			Object uid, String boardid) throws BizException {
		// 验证用户的输入
		Utils.checkNull(title,"标题不能为空");
		Utils.checkNull(content,"内容不能为空");
		
		try {
			tdao.insert(title,content,uid,boardid);
		} catch (SQLException e) {
			throw new BizException("系统繁忙，请求稍后再试",e);
		}
		
	}

}
