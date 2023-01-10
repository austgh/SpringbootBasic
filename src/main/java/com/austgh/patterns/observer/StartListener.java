/**
 * 
 */
package com.austgh.patterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author think
 *应用启动就会触发ApplicationStartedEvent
 */
//不检验过期方法
@SuppressWarnings("deprecation")
@Component
public class StartListener implements ApplicationListener<ApplicationStartedEvent> {
	Logger log = LoggerFactory.getLogger(StartListener.class);
	@Override
	public void onApplicationEvent(ApplicationStartedEvent arg0) {
		log.info("Spring启动完毕！");
	}
}

