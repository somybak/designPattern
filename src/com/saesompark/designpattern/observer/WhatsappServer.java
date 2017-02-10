package com.saesompark.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/*
 *옵저버 관리하는 메인 서버 
 * 
 */

public class WhatsappServer {

	//각 옵저버를 저장해두는 저장소
	List<Observer> observers = new ArrayList<>();
	public String data;
	
	//옵저버 저장소 -옵저버를 저장하는 역할
	public void addObserver(Observer observer){
		observers.add(observer);
		
	}
	
	//변경사항이 발생했을 때 옵저버들에게 통지하는 역할
	public void notification(String msg){
	//다른 메서드에서 호출하면 안됨 private
		// 올저버에는 업데이트 함수가 만들어저 있음. 옵저버 수만큼 모두에게 뿌려주는 함수
		for(Observer observer:observers)
			observer.update(msg);
		// 메시지를 직접 뿌려줌
		
	
	}
	
	//메시지 말생하면  보내주면됨. Student에서 서버를 참조하고 있음.
	public void sendMessage(String msg){
		
		
		notification(msg);
		// 나와 연결된 모든 다른 사람에게 알려줌. 전달해야하는 메시지가 발생하면 알려주는 함수 
		
	}
	
}
