package com.saesompark.factorymethod;

/*
 * Factory Method
 * 객체를 생성해주는 패턴
 * 확장한 무보클래스의 메서드를 오버라이드해서 반환해준다.
 */

public abstract class FactoryMethod {
	public abstract Product make();
	public abstract Packed pack(Product product);
//기본적으로 FactoryMethod 클래스를 받으면 이 두개를 모두 구현해야

}
