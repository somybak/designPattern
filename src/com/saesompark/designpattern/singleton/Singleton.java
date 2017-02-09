package com.saesompark.designpattern.singleton;

public class Singleton {
	/*
	 * 싱글턴 패턴은 자원을 공유하기 위한 목적으로 사용한다.
	 * Multi-Thread 환경에서는 아래 로직에 동기화를 추가해야한다.
	 */
	
	
	//현재 싱글턴 자체, 나를 담아두는 변수공간
	public static Singleton instance=null; // 항상 static으로 선언해야

	private Singleton(){} // 더이상 new를 하지 못하게 한다

	public static Singleton getInstance(){
		//1.instance 변수에 값이 있는지를 체크한다. 없으면 새로운 생성자를 만든다.(new)
		// 생성자가 private이지만 동일 class 안에 있기 때문에 new를 할 수 있다.
		
		if(instance==null){
			instance = new Singleton();
		}
		
		
		// 2. instance를 리턴한다
		return instance;
	
		// 공유자원으로서 의미가 큼. 어느 클래스에서나 이제 getIntance()로 사용	
	}

	public String name = "";
	
	public static Singleton newInstance(){
			return new Singleton();
		
	}
	
}
