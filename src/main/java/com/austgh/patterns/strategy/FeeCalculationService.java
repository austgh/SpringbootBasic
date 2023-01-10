/**
 * 
 */
package com.austgh.patterns.strategy;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author think
 *
 */
@Service
public class FeeCalculationService {
	
	Map<String, DiscountStrategy> stategyMap=new HashMap<String, DiscountStrategy>();
	
	//if else 高级处理 设计模式 工程模式  构造方法
	public FeeCalculationService(List<DiscountStrategy> discountStrategies) {
		for(DiscountStrategy discountStrategy:discountStrategies){
			stategyMap.put(discountStrategy.type(), discountStrategy);
		}
	}
	public double calculation(String type,double fee){
		DiscountStrategy discountStrategy=stategyMap.get(type);
		return discountStrategy.calculation(fee);
	}

}

