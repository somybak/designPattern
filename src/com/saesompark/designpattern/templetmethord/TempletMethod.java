package com.saesompark.designpattern.templetmethord;


/*
 * Templete Method
 * 부모 클래스인 템플릿 메서드(추상클래스)에 있는 추상함수가
 * 상속받은 자식 클래스가 구현한 메서드를 호출하는 패턴
 */

public abstract class TempletMethod {
	
	public void play(){
		System.out.println("플레이가 시작됩니다.");
		jump();
		
	}
	public abstract void jump();

}
