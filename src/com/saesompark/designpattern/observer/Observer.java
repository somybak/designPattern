package com.saesompark.designpattern.observer;
/*
 * Observer
 * 옵저버 인터페이스를 구현한 구현체들에게
 * 업데이트 사항을 자동으로 알려주는 패턴
 * 
 */

//단톡방 구현하기 - 새로운 대화가 있을 경우 알ㄹ려줌
public interface Observer {
	
	public void update();
	// 옵저버를 제공하는 서버 측에서 변경사항이 있을 경우 호출하는 함수
	 
	

}
