/**
 * 
 */
package com.austgh.patterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;


/**
 * @author think 观察者模式
 *
 */
public class OrderCreateEvent extends ApplicationEvent {
	Logger log = LoggerFactory.getLogger(OrderCreateEvent.class);

	/**
	 * @param source
	 */
	public OrderCreateEvent(Object source) {
		super(source);
		log.info("订单已经创建!");
	}
}

