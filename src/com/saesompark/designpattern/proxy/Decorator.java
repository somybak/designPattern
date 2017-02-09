package com.saesompark.designpattern.proxy;

public class Decorator {
	//���� ���� ������ ����
	private static Decorator instance = null;
	
	//������ ����
	private Decorator(){}
	//instance �����ؼ� �Ѱ���
	public static Decorator getInstance(){
		if(instance==null){
			instance = new Decorator();
			
		}
		return instance;
		
	}
	// �����Լ� getBbs ����
	public BbsExtend getBbs(int bbsno){
		BbsExtend bbs = Database.readBbsExtend(bbsno); 
		//���������͸� �����ͼ� ������ �� �Ѱ��ش�.
		bbs.count = bbs.count +1; //ī��Ʈ ����
		bbs.title = "����:"+bbs.title; //ī��Ʈ ����
		return bbs;
			
	}
}
