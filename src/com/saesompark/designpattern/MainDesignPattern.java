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
		// 싱글턴으로는 인스턴스를 계속 생성하지 않아도 됨. 라기보단 강제로 new를 한개만 하게함
		// 데이터를 계속 재사용! 객체를 공유함으로써 클래스를 공유
		// single, single1에서는 Single 클래스를 참조. 하나가 바꾸면 다 바.뀜. 
		
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
			
		//6. TV 공장 만들기  - 팩토리 패턴
		FactoryMethod factory = new TVfactory();
		Product product = factory.make();
		Packed packed = factory.pack(product);
		
		//7. 전략 패턴 사용. 클라이언트가 Main
		Strategy strategy = null;
		Soldier context = new Soldier();
		
		//클라이언트가 전략선택을 위해 상태를 변경
		context.status = Soldier.NEAR;
		
		//"적이 근접거리에 있다면"
		if(context.status == Soldier.ATTACKED){
			strategy = new StrategySword();
		}else{
			strategy = new StrategySheild();
		}
		
		//전략을 컨텍스트에 넘겨서 사용한다
		context.useStrategy(strategy);
		
		
		//8. 전략 call back 패턴 사용하기
		// 전략패턴과 동일한데 전략 자체를 클라이언트에서 익명객체로 생성한다.
		Strategy strategy2 = null;
		Soldier context2 = new Soldier();
		
		context2.status = Soldier.ATTACKED; // => 숫자값 2가 들어감
		
		
		// 전략 콜백은 수현체를 사용하지 않고 익명객체를 코드상에서 구현해준다.
		switch (context2.status){
		case Soldier.ATTACKED: // 2라고 써도됨. 협업을 위해선 숫자보단 직접쓰는게 좋음.
			context2.useStrategy( // 콜백을 위해서 현재 실행하고 있는 것
				//익명객체란?
				//변수가 없이 instance가 생성되는 것을 가르킨다
				//아래와 같이 변수를 지정하지 않고 바로 초기화할 수 있지만
				// 초기화된 곳 이외에서는 사용할 수 없다.
				
				new Strategy(){ // 익명객체
		
					@Override
					public void runStrategy() { //call back 부분
						useShield();
						System.out.println("휘두른다");
					}
	
					private void useShield(){
						
						System.out.println("숨을 가다듬고");
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
					System.out.println("막는다");
				}
				});
			}
		
		//9.옵저버 사용하기
		//옵저버를 사용하기 위해서는 서버가 먼저 생성되어야
		WhatsappServer server = new WhatsappServer();
			
		Student luz = new Student(server, "Luz");
		Student achim = new Student(server, "Achim");
		Student somy = new Student(server, "Saesom");
		
		// 8.2 서버를 통해 공지를 띄운다
		server.sendMessage("한시간만 있으면 점심시간입니다. 힘냅시다~~");
		//somy.addMessage("악");
		
		}
}
