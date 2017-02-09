package com.saesompark.designpattern.singleton;

public class Singleton {
	/*
	 * �̱��� ������ �ڿ��� �����ϱ� ���� �������� ����Ѵ�.
	 * Multi-Thread ȯ�濡���� �Ʒ� ������ ����ȭ�� �߰��ؾ��Ѵ�.
	 */
	
	
	//���� �̱��� ��ü, ���� ��Ƶδ� ��������
	public static Singleton instance=null; // �׻� static���� �����ؾ�

	private Singleton(){} // ���̻� new�� ���� ���ϰ� �Ѵ�

	public static Singleton getInstance(){
		//1.instance ������ ���� �ִ����� üũ�Ѵ�. ������ ���ο� �����ڸ� �����.(new)
		// �����ڰ� private������ ���� class �ȿ� �ֱ� ������ new�� �� �� �ִ�.
		
		if(instance==null){
			instance = new Singleton();
		}
		
		
		// 2. instance�� �����Ѵ�
		return instance;
	
		// �����ڿ����μ� �ǹ̰� ŭ. ��� Ŭ���������� ���� getIntance()�� ���	
	}

	public String name = "";
	
	public static Singleton newInstance(){
			return new Singleton();
		
	}
	
}
