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
		// 싱글턴으로는 인스턴스를 계속 생성하지 않아도 됨. 라기보단 강제로 new를 한개만 하게함
		// 데이터를 계속 재사용! 객체를 공유함으로써 클래스를 공유
		// single, single1에서는 Single 클래스를 참조. 하나가 바꾸면 다 바뀜. 
		
		// 객체의 new를 한번만 하게 하려고 나온게 싱글턴!!
		
		Singleton single = Singleton.getInstance();
		
		// Singleton에서 더이상 new를 하지 못하게 private Singleton(){}을 선언했으므로
		// Singleton single1 = new Singleton(); <= 이거는 이제 오류남
		
		// 여기서는 Singleton에서 instance를 new해서 리턴해줌 		
		Singleton single1 = Singleton.getInstance();
		// 이미 만들어졌기 때문에 Singleton에서 새로 만들지 않고 원래 있는 instance를 리턴  		
		
		System.out.printf("single.name=%s single1.name=%s \n", single.name, single1.name);
		single.name= "홍길동";		
		System.out.printf("single.name=%s single1.name=%s \n", single.name, single1.name);
		
		//2. 멀티턴 사용해보기
		Multiton multi = Multiton.newInstance();
		Multiton multi1 = Multiton.newInstance();
		
		System.out.printf("multi.name=%s multi1.name=%s \n", multi.name, multi1.name);
		multi.name= "이순신";		
		System.out.printf("multi.name=%s multi1.name=%s \n", multi.name, multi1.name);
	
		//3. 싱글턴에 newInstance() 함수를 추가하고 변수 single3에 적용한 후 single3를 출력
		
		Singleton single3 = Singleton.newInstance();
		System.out.printf("single3.name=%s \n", single3.name);		
		
		//4. Proxy 사용
		
		Proxy proxy = Proxy.getInstance();
		Bbs bbs = proxy.getBbs(33); // 임의 게시판 번호
		System.out.printf("no=%d, title=%s, content=%s \n", bbs.no, bbs.title, bbs.content);
		
		// 5. 템플릿	
		TempletMethod frog = new Frog();
		frog.play();
			
		//6. TV 공장 만들기 
		FactoryMethod factory = new TVfactory();
		Product product = factory.make();
		Packed packed = factory.pack(product);
		
	}

}
