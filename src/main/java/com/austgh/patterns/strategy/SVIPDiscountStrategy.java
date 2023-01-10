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
public class SVIPDiscountStrategy implements DiscountStrategy {

	@Override
	public double calculation(double fee) {
		return fee*0.8;
	}

	@Override
	public String type() {
		return "svip";
	}
}

