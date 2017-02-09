package com.saesompark.designpattern;

import com.saesompark.designpattern.proxy.Bbs;
import com.saesompark.designpattern.proxy.Proxy;
import com.saesompark.designpattern.singleton.Multiton;
import com.saesompark.designpattern.singleton.Singleton;
import com.saesompark.designpattern.templetmethord.Frog;
import com.saesompark.designpattern.templetmethord.TempletMethod;
import com.saesompark.factorymethod.FactoryMethod;
import com.saesompark.factorymethod.Packed;
import com.saesompark.factorymethod.Product;
import com.saesompark.factorymethod.TVfactory;

public class MainDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �̱������δ� �ν��Ͻ��� ��� �������� �ʾƵ� ��. ��⺸�� ������ new�� �Ѱ��� �ϰ���
		// �����͸� ��� ����! ��ü�� ���������ν� Ŭ������ ����
		// single, single1������ Single Ŭ������ ����. �ϳ��� �ٲٸ� �� �ٲ�. 
		
		// ��ü�� new�� �ѹ��� �ϰ� �Ϸ��� ���°� �̱���!!
		
		Singleton single = Singleton.getInstance();
		
		// Singleton���� ���̻� new�� ���� ���ϰ� private Singleton(){}�� ���������Ƿ�
		// Singleton single1 = new Singleton(); <= �̰Ŵ� ���� ������
		
		// ���⼭�� Singleton���� instance�� new�ؼ� �������� 		
		Singleton single1 = Singleton.getInstance();
		// �̹� ��������� ������ Singleton���� ���� ������ �ʰ� ���� �ִ� instance�� ����  		
		
		System.out.printf("single.name=%s single1.name=%s \n", single.name, single1.name);
		single.name= "ȫ�浿";		
		System.out.printf("single.name=%s single1.name=%s \n", single.name, single1.name);
		
		//2. ��Ƽ�� ����غ���
		Multiton multi = Multiton.newInstance();
		Multiton multi1 = Multiton.newInstance();
		
		System.out.printf("multi.name=%s multi1.name=%s \n", multi.name, multi1.name);
		multi.name= "�̼���";		
		System.out.printf("multi.name=%s multi1.name=%s \n", multi.name, multi1.name);
	
		//3. �̱��Ͽ� newInstance() �Լ��� �߰��ϰ� ���� single3�� ������ �� single3�� ���
		
		Singleton single3 = Singleton.newInstance();
		System.out.printf("single3.name=%s \n", single3.name);		
		
		//4. Proxy ���
		
		Proxy proxy = Proxy.getInstance();
		Bbs bbs = proxy.getBbs(33); // ���� �Խ��� ��ȣ
		System.out.printf("no=%d, title=%s, content=%s \n", bbs.no, bbs.title, bbs.content);
		
		// 5. ���ø�	
		TempletMethod frog = new Frog();
		frog.play();
			
		//6. TV ���� ����� 
		FactoryMethod factory = new TVfactory();
		Product product = factory.make();
		Packed packed = factory.pack(product);
		
	}

}
