package com.saesompark.designpattern.proxy;

public class Decorator {
	//나를 담을 변수를 선언
	private static Decorator instance = null;
	
	//생성을 금지
	private Decorator(){}
	//instance 생성해서 넘겨줌
	public static Decorator getInstance(){
		if(instance==null){
			instance = new Decorator();
			
		}
		return instance;
		
	}
	// 대행함수 getBbs 구현
	public BbsExtend getBbs(int bbsno){
		BbsExtend bbs = Database.readBbsExtend(bbsno); 
		//원본데이터를 가져와서 가공한 후 넘겨준다.
		bbs.count = bbs.count +1; //카운트 세기
		bbs.title = "제목:"+bbs.title; //카운트 세기
		return bbs;
			
	}
}
