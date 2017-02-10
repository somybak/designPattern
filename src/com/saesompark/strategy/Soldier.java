package com.saesompark.strategy;

import com.saesompark.designpattern.MainDesignPattern;

/*
 * 전략 사용하는 Context 객체
 */

public class Soldier {
	
	public static final int NEAR = 0;
	public static final int FAR = 1;
	public static final int ATTACKED = 2;
	
	public int status = FAR;
				
	public void useStrategy(Strategy strategy){
		System.out.println("--전투시작--");
		
		strategy.runStrategy();
		
		System.out.println("--전투끗--");
	}
	
}
