package com.github.chaijunkun.wechat.common.draft.test;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础测试类
 * @author chaijunkun
 * @since 2016年9月6日
 */
public abstract class BaseTest {
	
	protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	
	private long startTime;
	
	@Before
	public void doBefore(){
		logger.info("单元测试开始");
		startTime = System.currentTimeMillis();
	}

	@After
	public void doAfter(){
		long endTime = System.currentTimeMillis();
		logger.info("单元测试结束,耗时:{}毫秒", endTime - startTime);
		logger.info("=================");
	}
	
}
