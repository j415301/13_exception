package com.exception.controller;

import java.io.IOException;

public class SubException extends ExceptionHandle{

	@Override
	public void fileLoad2() throws IOException{//������ ����ó�� �������� ������ �ȵ�
		System.out.println("�������̵�");
	}
	
	
}
