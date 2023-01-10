/**
 * 
 */
package com.austgh.patterns.strategy;


/**
 * @author think
 *根据不同的类型，计算不同的结果
 */
public interface DiscountStrategy {
	public String type();
	public double calculation(double fee);
}


