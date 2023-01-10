/**
 * 
 */
package com.austgh.patterns.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author think
 *
 */
@Service
public class OrderService {
	//spring容器
	@Autowired
	ApplicationContext applicationContext;

	public String saveOrder(){
		//利用spring 机制去实现观察者
		OrderCreateEvent orderCreateEvent=new OrderCreateEvent(new Object());
		applicationContext.publishEvent(orderCreateEvent);
		return "ok";
	}
}

