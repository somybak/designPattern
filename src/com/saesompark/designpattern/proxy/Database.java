package com.saesompark.designpattern.proxy;

public class Database {
	public static Bbs readBbs(int bbsno){
		Bbs bbs =new BbsExtend();
		//데이터를 세팅한 후에 리턴해준다
		//로직...BbsExtend
		bbs.no = bbsno;
		bbs.title = "빨라";
		bbs.content = "심하게";
	
		return bbs;
	
	}
	
	public static void increaseVisit(int bbsno){
		//Visit 데이터는 현재의 Bbs와 별개로 존재한다.
		
		
	}

	//대신해서 전달해 주는 부분
	public static BbsExtend readBbsExtend(int bbsno) {
		// TODO Auto-generated method stub
		BbsExtend bbs =new BbsExtend();
		//데이터를 세팅한 후에 리턴해준다
		//로직...BbsExtend
		bbs.no = bbsno;
		bbs.title = "빨라";
		bbs.content = "심하게";
		bbs.count = 3;
		
		return bbs;
	}
}
