/**
 * 
 */
package com.austgh.patterns.strategy;

import org.springframework.stereotype.Service;

/**
 * @author think
 *
 */
@Service
public class VIPDiscountStategy implements DiscountStrategy {

	@Override
	public double calculation(double fee) {
		
		return fee*0.9;
	}

	@Override
	public String type() {
		return "vip";
	}
	
}

