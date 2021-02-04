package com.exception.common;

import java.io.Serializable;

//나만의 예외처리 객체를 만들자
//Exception 객체를 상속받으면 Exception 객체가 됨
public class MyException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 4119272505420334756L;

	public MyException(String name) {
		super(name);
	}

}
