package com.fairyhawk.service.mq;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NotifyMessageListener implements MessageListener{

	private static Logger logger = LoggerFactory.getLogger(NotifyMessageListener.class);

	/**
	 * MessageListener回调函数.
	 */
	@Override
	public void onMessage(Message message) {
		try {
			
			logger.info("++++ 接手消息 ");
			MapMessage mapMessage = (MapMessage) message;
			//打印消息详情
			logger.info("UserName:{}, Email:{}", mapMessage.getString("userName"), mapMessage.getString("email"));

		} catch (Exception e) {
			logger.error("处理消息时发生异常.", e);
		}
	}

}
