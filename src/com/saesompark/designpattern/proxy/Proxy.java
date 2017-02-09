package com.saesompark.designpattern.proxy;


/*Proxy
 * 대행자로써
 * 중간에 다른 기능 또는 요구사항을 처리한 후
 * 클라이언트 요청에 대한 원본 데이터는 변형하지 않고 그대로 전달한다.
 */

public class Proxy {
	
	//싱글톤
	private static Proxy instance = null;
	private Proxy (){}
	
	public static Proxy getInstance(){
		if(instance==null){
			instance = new Proxy();
			
		}
		return instance;
		
	}
	
	public Bbs getBbs(int bbsno){
		Bbs bbs = Database.readBbs(bbsno); // 데이터 베이스를 통해 가져올 것을 가정...
		
		// 원본데이터는 변형하지 않고 조회수 또는 좋아요 수를 증가시켜준다
		// 좋아요 같은 경우 따로 좋아요한 리스트까지 처리
		//로그인 처리. - 상세보기 보려면 로그인 하게요
		Visit visit = new Visit();
		visit.increase(bbsno);
		return bbs;
			
	}
}
