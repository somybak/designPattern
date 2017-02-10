package com.saesompark.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/*
 *������ �����ϴ� ���� ���� 
 * 
 */

public class WhatsappServer {

	//�� �������� �����صδ� �����
	List<Observer> observers = new ArrayList<>();
	public String data;
	
	//������ ����� -�������� �����ϴ� ����
	public void addObserver(Observer observer){
		observers.add(observer);
		
	}
	
	//��������� �߻����� �� �������鿡�� �����ϴ� ����
	public void notification(String msg){
	//�ٸ� �޼��忡�� ȣ���ϸ� �ȵ� private
		// ���������� ������Ʈ �Լ��� ������� ����. ������ ����ŭ ��ο��� �ѷ��ִ� �Լ�
		for(Observer observer:observers)
			observer.update(msg);
		// �޽����� ���� �ѷ���
		
	
	}
	
	//�޽��� �����ϸ�  �����ָ��. Student���� ������ �����ϰ� ����.
	public void sendMessage(String msg){
		
		
		notification(msg);
		// ���� ����� ��� �ٸ� ������� �˷���. �����ؾ��ϴ� �޽����� �߻��ϸ� �˷��ִ� �Լ� 
		
	}
	
}
