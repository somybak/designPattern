package com.saesompark.designpattern.observer;


import java.util.ArrayList;
import java.util.List;

public class Student implements Observer {

//��������  �����ϴ� ��
	
	WhatsappServer server;
	String name = "";
	
	public Student(WhatsappServer server, String name){
		this.server = server;
		server.addObserver(this);
		this.name = name;//������Ʈ �Ǹ� ���� ȣ���ϱ� ���� �Լ�
		
	}	
	
	//�޽��� �����ϴ� �����
	
	List<String> messages = new ArrayList<>();
	
	@Override
	public void update(String msg) {
		// TODO Auto-generated method stub
		// String msg = server.data;
		messages.add(msg);
		showMessage();
		
		//�޽����� ȣ������
	}

	public void addMessage(String msg){
		// DB�� �� ������ ���� ���ƿ��� ������׸� �� �������� ������ - �װ� �޴� ��
		server.sendMessage(msg);
		//Ÿ������ ���� ���ƿ��� �޽���
	}
	
	public void showMessage(){
		//���� �Է��������� �� ��Ÿ�� ������ �����͸� ������
		// ������ �޽����� �ѷ���
		System.out.println(name+"���� �� �޽���:" + messages.get(messages.size()-1));
		
	}

}
