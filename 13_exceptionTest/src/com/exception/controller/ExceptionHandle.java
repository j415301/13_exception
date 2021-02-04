package com.exception.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.exception.common.MyException;

public class ExceptionHandle{
	
	public void testException() throws FileNotFoundException{//에러를 호출 장소로 위임
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
			//FileNotFoundException 캐치하지 않아도 fnfe의 부모인 IOException이 자식 것까지 예외처리 해줌
			//혹은 IOE 캐치 다음에 FNFE캐치문을 작성하면 이미 IOE에서 모든 Exception을 해결했기 때문에 FNFE캐지문은 죽은 코드가 되어 에러가 남
			
			e.printStackTrace();
			
			//try문에서 선언한 변수는 try문에서만 사용 가능
			//fr.read();//불가능
			//int a = data;//불가능
		} finally {
			//파일 입출력 객체를 반환할 때(닫아줄 때) 많이 사용됨
			System.out.println("이거슨 실행되니?");
		}
		System.out.println("try구문 밖에서 있는 구문");
		
		//try에서 선언한 변수를 외부에서 사용할 수 있을까?
		//fr.read();//불가능
		//int a = data;//불가능
		
		
	}
	
	//Exception객체들도 상속 관계에 따른 처리 방법이 있음
	//Exception 객체는 모든 하위 Exception의 부모
	//Exception들은 각 관계에 따라 부모, 자식 관계가 있음
	//예외 처리시 부모 Exception은 자식 Exception을 처리할 수 있음
	//무조건 자식 Exception 캐치문부터 쓰고 부모 Exception 캐치문을 찾아야 함
	
	
	public void fileLoad() {
		FileReader fr = null;//읽어올 때 항상 닫아줘야 함
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
			//나중에 닫을 객체를 소괄호에 씀 (여러개 써도 됨)
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
		System.out.print("암호 입력 : ");
		String pw = sc.next();
		if (!pw.equals("1234")) {
			//나만의 예외 발생시키기: throw 예약어 이용
			throw new MyException("암호가 다름!");
		}
	}
}

