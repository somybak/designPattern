package com.saesompark.designpattern.singleton;

/*
 * Multiton
 * 싱글턴과 반대되는 개념이지만 new라는 의존성(dependency)를 제거해준다는 장점이 있다.
 */

public class Multiton {
	//생성자를 private로 막는다
	private Multiton(){}
	
	//생성함수를 제공한다.
	public static Multiton newInstance(){
		return new Multiton();
		
	}
	
	public String name = "";
	
	
}
