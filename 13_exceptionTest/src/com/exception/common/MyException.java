package com.exception.common;

import java.io.Serializable;

//������ ����ó�� ��ü�� ������
//Exception ��ü�� ��ӹ����� Exception ��ü�� ��
public class MyException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 4119272505420334756L;

	public MyException(String name) {
		super(name);
	}

}
