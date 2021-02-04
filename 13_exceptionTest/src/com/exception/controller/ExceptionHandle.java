package com.exception.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.exception.common.MyException;

public class ExceptionHandle{
	
	public void testException() throws FileNotFoundException{//������ ȣ�� ��ҷ� ����
		new FileReader("test.txt");
	}
	
	public void tryCatchTest() {
		try {
			FileReader fr = new FileReader("test.txt");
			int data = -1;
			while ((data = fr.read()) != -1) {
			}
		}/* catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}*/ catch (IOException e){
			//FileNotFoundException ĳġ���� �ʾƵ� fnfe�� �θ��� IOException�� �ڽ� �ͱ��� ����ó�� ����
			//Ȥ�� IOE ĳġ ������ FNFEĳġ���� �ۼ��ϸ� �̹� IOE���� ��� Exception�� �ذ��߱� ������ FNFEĳ������ ���� �ڵ尡 �Ǿ� ������ ��
			
			e.printStackTrace();
			
			//try������ ������ ������ try�������� ��� ����
			//fr.read();//�Ұ���
			//int a = data;//�Ұ���
		} finally {
			//���� ����� ��ü�� ��ȯ�� ��(�ݾ��� ��) ���� ����
			System.out.println("�̰Ž� ����Ǵ�?");
		}
		System.out.println("try���� �ۿ��� �ִ� ����");
		
		//try���� ������ ������ �ܺο��� ����� �� ������?
		//fr.read();//�Ұ���
		//int a = data;//�Ұ���
		
		
	}
	
	//Exception��ü�鵵 ��� ���迡 ���� ó�� ����� ����
	//Exception ��ü�� ��� ���� Exception�� �θ�
	//Exception���� �� ���迡 ���� �θ�, �ڽ� ���谡 ����
	//���� ó���� �θ� Exception�� �ڽ� Exception�� ó���� �� ����
	//������ �ڽ� Exception ĳġ������ ���� �θ� Exception ĳġ���� ã�ƾ� ��
	
	
	public void fileLoad() {
		FileReader fr = null;//�о�� �� �׻� �ݾ���� ��
		try {
			fr = new FileReader("test.txt");
			int data = -1;
			while ((data = fr.read())!=-1) {
				System.out.println((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr!=null) fr.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	//try~with~resource
	public void fileLoad2() throws IOException{
		try (FileReader fr = new FileReader("test.txt");
				BufferedReader br = new BufferedReader(fr);){
			//���߿� ���� ��ü�� �Ұ�ȣ�� �� (������ �ᵵ ��)
			int data = -1;
			while ((data = fr.read()) != -1) {
				System.out.println((char)data);
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	
	public void myExceptionUse() throws MyException {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȣ �Է� : ");
		String pw = sc.next();
		if (!pw.equals("1234")) {
			//������ ���� �߻���Ű��: throw ����� �̿�
			throw new MyException("��ȣ�� �ٸ�!");
		}
	}
}

