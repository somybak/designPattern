package com.saesompark.designpattern;

import com.saesompark.designpattern.observer.Student;
import com.saesompark.designpattern.observer.WhatsappServer;
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
import com.saesompark.strategy.Soldier;
import com.saesompark.strategy.Strategy;
import com.saesompark.strategy.StrategySheild;
import com.saesompark.strategy.StrategySword;

public class MainDesignPattern {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �̱������δ� �ν��Ͻ��� ��� �������� �ʾƵ� ��. ��⺸�� ������ new�� �Ѱ��� �ϰ���
		// �����͸� ��� ����! ��ü�� ���������ν� Ŭ������ ����
		// single, single1������ Single Ŭ������ ����. �ϳ��� �ٲٸ� �� ��.��. 
		
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
			
		//6. TV ���� �����  - ���丮 ����
		FactoryMethod factory = new TVfactory();
		Product product = factory.make();
		Packed packed = factory.pack(product);
		
		//7. ���� ���� ���. Ŭ���̾�Ʈ�� Main
		Strategy strategy = null;
		Soldier context = new Soldier();
		
		//Ŭ���̾�Ʈ�� ���������� ���� ���¸� ����
		context.status = Soldier.NEAR;
		
		//"���� �����Ÿ��� �ִٸ�"
		if(context.status == Soldier.ATTACKED){
			strategy = new StrategySword();
		}else{
			strategy = new StrategySheild();
		}
		
		//������ ���ؽ�Ʈ�� �Ѱܼ� ����Ѵ�
		context.useStrategy(strategy);
		
		
		//8. ���� call back ���� ����ϱ�
		// �������ϰ� �����ѵ� ���� ��ü�� Ŭ���̾�Ʈ���� �͸�ü�� �����Ѵ�.
		Strategy strategy2 = null;
		Soldier context2 = new Soldier();
		
		context2.status = Soldier.ATTACKED; // => ���ڰ� 2�� ��
		
		
		// ���� �ݹ��� ����ü�� ������� �ʰ� �͸�ü�� �ڵ�󿡼� �������ش�.
		switch (context2.status){
		case Soldier.ATTACKED: // 2��� �ᵵ��. ������ ���ؼ� ���ں��� �������°� ����.
			context2.useStrategy( // �ݹ��� ���ؼ� ���� �����ϰ� �ִ� ��
				//�͸�ü��?
				//������ ���� instance�� �����Ǵ� ���� ����Ų��
				//�Ʒ��� ���� ������ �������� �ʰ� �ٷ� �ʱ�ȭ�� �� ������
				// �ʱ�ȭ�� �� �̿ܿ����� ����� �� ����.
				
				new Strategy(){ // �͸�ü
		
					@Override
					public void runStrategy() { //call back �κ�
						useShield();
						System.out.println("�ֵθ���");
					}
	
					private void useShield(){
						
						System.out.println("���� ���ٵ��");
					}
				}
			);
				break;
				
//		case Soldier.FAR:
//			context2.useStrategy(
//				new Strategy(){
//					@Override
//					public void runStrategy() {
//						 useShield();
//					}
//				}
//			);
//			break;
			
		default:
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					// TODO Auto-generated method stub
					System.out.println("���´�");
				}
				});
			}
		
		//9.������ ����ϱ�
		//�������� ����ϱ� ���ؼ��� ������ ���� �����Ǿ��
		WhatsappServer server = new WhatsappServer();
			
		Student luz = new Student(server, "Luz");
		Student achim = new Student(server, "Achim");
		Student somy = new Student(server, "Saesom");
		
		// 8.2 ������ ���� ������ ����
		server.sendMessage("�ѽð��� ������ ���ɽð��Դϴ�. �����ô�~~");
		//somy.addMessage("��");
		
		}
}
