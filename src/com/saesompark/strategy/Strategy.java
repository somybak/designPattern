package com.saesompark.strategy;

/*
 * 
 * Strategy
 * 
 * 템플릿 패턴과 유사한데, 템플릿 패턴이 상속을 이용하는 반면
 * Strategy 패턴은 객체주입을 통해 다양한 결과를 도출할 수 있다.
 * 
 * 3개 요소 필요
 * 1. 전략 : 실제 로직을 구현하는 객체
 * 2. 컨텍스트 : 전략을 사용하는 객체
 * 3. 클라이언트 : 전략 객체를 생성한 후 컨텍스트에 주입하는 객체
 * 
 */

public abstract class Strategy {

	public abstract void runStrategy();

	
	
}
