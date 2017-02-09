package com.saesompark.designpattern.proxy;


/*Proxy
 * �����ڷν�
 * �߰��� �ٸ� ��� �Ǵ� �䱸������ ó���� ��
 * Ŭ���̾�Ʈ ��û�� ���� ���� �����ʹ� �������� �ʰ� �״�� �����Ѵ�.
 */

public class Proxy {
	
	//�̱���
	private static Proxy instance = null;
	private Proxy (){}
	
	public static Proxy getInstance(){
		if(instance==null){
			instance = new Proxy();
			
		}
		return instance;
		
	}
	
	public Bbs getBbs(int bbsno){
		Bbs bbs = Database.readBbs(bbsno); // ������ ���̽��� ���� ������ ���� ����...
		
		// ���������ʹ� �������� �ʰ� ��ȸ�� �Ǵ� ���ƿ� ���� ���������ش�
		// ���ƿ� ���� ��� ���� ���ƿ��� ����Ʈ���� ó��
		//�α��� ó��. - �󼼺��� ������ �α��� �ϰԿ�
		Visit visit = new Visit();
		visit.increase(bbsno);
		return bbs;
			
	}
}
