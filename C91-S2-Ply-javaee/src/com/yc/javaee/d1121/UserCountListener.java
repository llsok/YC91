package com.yc.javaee.d1121;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 统计在线人数： 上线： LoginServlet==》 向会话添加了 loginedAccount 属性 下线：
 * 	1.移除会话中 loginedAccount 属性 
 * 	2.会话失效
 * 
 * 
 * 会话属性监听
 */
@WebListener
public class UserCountListener implements HttpSessionAttributeListener {

	// 在线人数
	private int count = 0;

	/**
	 * 添加属性之后，触发该方法
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		event.getSession(); // 获取会话对象
		event.getName(); // 获取添加的属性名
		event.getValue(); // 获取添加的属性值
		if ("loginedAccount".equals(event.getName())) {
			count++;
			// 应用上下文对象 ServletContext： 生命周期长， 作用域广
			// 向应用上下文对象保存了一个属性值
			event.getSession().getServletContext().setAttribute("count", count);
		}
	}

	/**
	 * 移除一个属性之后，触发该方法
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if ("loginedAccount".equals(event.getName())) {
			count--;
			event.getSession().getServletContext().setAttribute("count", count);
		}
	}

	/**
	 * 替换一个属性之后，触发该方法
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

}
