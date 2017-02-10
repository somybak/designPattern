package com.saesompark.designpattern.observer;


import java.util.ArrayList;
import java.util.List;

public class Student implements Observer {

//서버에서  저장하는 곳
	
	WhatsappServer server;
	String name = "";
	
	public Student(WhatsappServer server, String name){
		this.server = server;
		server.addObserver(this);
		this.name = name;//업데이트 되면 나를 호출하기 위한 함수
		
	}	
	
	//메시지 보관하는 저장소
	
	List<String> messages = new ArrayList<>();
	
	@Override
	public void update(String msg) {
		// TODO Auto-generated method stub
		// String msg = server.data;
		messages.add(msg);
		showMessage();
		
		//메시지를 호출해줌
	}

	public void addMessage(String msg){
		// DB는 내 쪽으로 뭐가 날아오면 변경사항만 각 옵저버에 날려줌 - 그걸 받는 곳
		server.sendMessage(msg);
		//타이핑을 통해 날아오는 메시지
	}
	
	public void showMessage(){
		//내가 입력했을때는 안 나타남 남들이 보낸것만 보내줌
		// 마지막 메시지만 뿌려줌
		System.out.println(name+"에게 온 메시지:" + messages.get(messages.size()-1));
		
	}

}
