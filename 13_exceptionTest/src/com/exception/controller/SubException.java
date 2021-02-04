package com.exception.controller;

import java.io.IOException;

public class SubException extends ExceptionHandle{

	@Override
	public void fileLoad2() throws IOException{//원본의 예외처리 범위보다 넓으면 안됨
		System.out.println("오버라이드");
	}
	
	
}
