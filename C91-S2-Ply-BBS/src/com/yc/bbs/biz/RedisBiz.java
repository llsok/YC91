package com.yc.bbs.biz;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisBiz {
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis(); // 默认访问本机6379
		try{
			System.out.println(jedis.keys("*"));
		} finally {
			jedis.close();
		}
	}
	
	// jedis 连接池， 事先创建好N个连接
	JedisPool jedisPool = new JedisPool(); 
	/**
	 * 1 请求中获取的参数都是 string 类型
	 * 2 jdbc 可以对一些基本的数据类型进行自动转换
	 * @param topicid 1,2,3
	 */
	public void zan(String topicid, String uid){
		
		/**
		 * 保存帖子点赞数
		 * 
		 * 方案1： 为每个帖子id 建一个key ==> 
		 * 		topic_zan_1 : 200
		 * 		topic_zan_2 : 150
		 * 		topic_zan_3 : 120
		 * 
		 * 方案2： 使用一个 map 集合保存所有帖子的点赞数
		 * 		
		 * 		添加帖子点赞数：
		 * 			查找帖子， 返回其点赞数
		 * 			然后根据点赞数+1
		 */
		// 从连接池中获取一个连接
		Jedis jedis = jedisPool.getResource();
		try{
			String key  = "topic_zan_" + topicid;
			// 点赞数 + 1
			jedis.hincrBy("topic_zan_map", key, 1);
		} finally {
			jedis.close();
		}
		
	}
	
	public int getZan(String topicid){
		Jedis jedis = jedisPool.getResource();
		try{
			String key  = "topic_zan_" + topicid;
			// 点赞数 + 1
			String value = jedis.hget("topic_zan_map", key);
			return value == null ? 0 : Integer.parseInt(value);
		} finally {
			jedis.close();
		}
	}

}
