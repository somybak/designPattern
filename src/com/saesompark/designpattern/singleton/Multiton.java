package com.saesompark.designpattern.singleton;

/*
 * Multiton
 * �̱��ϰ� �ݴ�Ǵ� ���������� new��� ������(dependency)�� �������شٴ� ������ �ִ�.
 */

public class Multiton {
	//�����ڸ� private�� ���´�
	private Multiton(){}
	
	//�����Լ��� �����Ѵ�.
	public static Multiton newInstance(){
		return new Multiton();
		
	}
	
	public String name = "";
	
	
}
