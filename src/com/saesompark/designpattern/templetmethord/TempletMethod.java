package com.saesompark.designpattern.templetmethord;


/*
 * Templete Method
 * �θ� Ŭ������ ���ø� �޼���(�߻�Ŭ����)�� �ִ� �߻��Լ���
 * ��ӹ��� �ڽ� Ŭ������ ������ �޼��带 ȣ���ϴ� ����
 */

public abstract class TempletMethod {
	
	public void play(){
		System.out.println("�÷��̰� ���۵˴ϴ�.");
		jump();
		
	}
	public abstract void jump();

}
