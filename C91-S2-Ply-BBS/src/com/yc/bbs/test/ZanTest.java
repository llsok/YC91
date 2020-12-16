package com.yc.bbs.test;

import org.junit.Assert;
import org.junit.Test;

import com.yc.bbs.biz.RedisBiz;

public class ZanTest {
	
	private RedisBiz rbiz = new RedisBiz();
	
	@Test
	public void test1(){
		
		rbiz.zan("1", "1");
		rbiz.zan("1", "2");
		rbiz.zan("1", "3");
		rbiz.zan("2", "1");
		
		Assert.assertEquals(3, rbiz.getZan("1"));
		Assert.assertEquals(1, rbiz.getZan("2"));
		
	}

}
