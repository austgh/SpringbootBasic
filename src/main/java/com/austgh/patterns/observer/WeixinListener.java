/**
 * 
 */
package com.austgh.patterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author think
 *
 */
@Component
public class WeixinListener implements ApplicationListener<OrderCreateEvent>{
	Logger log = LoggerFactory.getLogger(WeixinListener.class);
	@Override
	public void onApplicationEvent(OrderCreateEvent event) {
		log.info("监听到OrderCreateEvent事件，开始发送微信!");
	}
}

