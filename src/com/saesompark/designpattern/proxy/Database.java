package com.saesompark.designpattern.proxy;

public class Database {
	public static Bbs readBbs(int bbsno){
		Bbs bbs =new BbsExtend();
		//�����͸� ������ �Ŀ� �������ش�
		//����...BbsExtend
		bbs.no = bbsno;
		bbs.title = "����";
		bbs.content = "���ϰ�";
	
		return bbs;
	
	}
	
	public static void increaseVisit(int bbsno){
		//Visit �����ʹ� ������ Bbs�� ������ �����Ѵ�.
		
		
	}

	//����ؼ� ������ �ִ� �κ�
	public static BbsExtend readBbsExtend(int bbsno) {
		// TODO Auto-generated method stub
		BbsExtend bbs =new BbsExtend();
		//�����͸� ������ �Ŀ� �������ش�
		//����...BbsExtend
		bbs.no = bbsno;
		bbs.title = "����";
		bbs.content = "���ϰ�";
		bbs.count = 3;
		
		return bbs;
	}
}
