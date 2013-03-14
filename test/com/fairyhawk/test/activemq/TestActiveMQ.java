package com.fairyhawk.test.activemq;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.fairyhawk.service.mq.NotifyMessageProducer;
import com.fairyhawk.test.Threads;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })

public class TestActiveMQ {

	private NotifyMessageProducer notifyMessageProducer;
	private static Logger logger = LoggerFactory.getLogger(TestActiveMQ.class);
	@Test
	public void test() {
		logger.info("+++ test send message start +++ ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNmae", "liuqinggang");
		map.put("email", "7305@qq.com");
	 
		
		notifyMessageProducer.sendQueue(map);
		logger.info("+++ send message ok +++ ");
		Threads.sleep(1000);
		
		
		 
	}
	public NotifyMessageProducer getNotifyMessageProducer() {
		return notifyMessageProducer;
	}
	public void setNotifyMessageProducer(NotifyMessageProducer notifyMessageProducer) {
		this.notifyMessageProducer = notifyMessageProducer;
	}

}
