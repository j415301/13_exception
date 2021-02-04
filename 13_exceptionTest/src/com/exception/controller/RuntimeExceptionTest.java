package com.exception.controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.exception.common.MyException;

public class RuntimeExceptionTest {
	
	public static void main(String[] args)  throws FileNotFoundException{
		                                   //재위임 -> JVM으로 위임함
		                                   //-> 일반 에러처럼 static trace가 출력되도록 예외처리해줌
		//Unchecked Exception
		//ArithmeticException  : 수학적으로 계산이 불가능한 경우에 발생
		Scanner sc = new Scanner(System.in);
		System.out.print("수 : ");
		int su = sc.nextInt();
		System.out.print("수 : ");
		int su1 = sc.nextInt();
		try {
			System.out.println(su/su1);
		} catch(ArithmeticException e) {//이 exception에 대한 정보를 이 매개변수 e에 넣어줌
			System.out.println(e.getMessage());//Exception에 대한 메세지: / by zero
			e.printStackTrace();//exception 발생지점을 확인할 수 있는 출력구문
			System.out.println("숫자에 0이 있습니다. 0으로 나눌 수는 없어요!");
		}//예외처리
		
		//NegativeArraySizeException : 배열 길이가 음수일 때 발생
		//int[] arrInt = new int[-10];//일ㅅ단 컴파일 에러는 안 남 but 실행 시 에러
		
		//ArrayIndexOutOfBoundsException : 접근한 인덱스가 배열 길이를 초과할 때 발생
		String[] names = new String[2];
		try {
			names[3] = "유병승";//컴파일 에러는 안남 but 실행 시 에러
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위를 초과했습니다!");
			String[] temp = new String[names.length+10];
			System.arraycopy(names, 0, temp, 0, names.length);
			names = temp;//names의 주소를 바꿈==names에 temp를 넣음
			names[3] = "유병승";
		}//예외처리
		System.out.println("실행되니?");
		System.out.println(names[3]);
		
		//ClassCastingException : 클래스 형변환 시 에러
		Object obj = new String("안녕");
		//Scanner sc2 = (Scanner)obj;//컴파일 에러는 안 남 but 실행 시 에러
		
		
		
		//checkedException: 반드시 예외처리를 해야 함
		//FileReader fr = new FileReader("test.txt");
		
		//new ExceptionHandle().testException();//호출 장소, 재위임 가능
		//new ExceptionHandle().tryCatchTest();
		//new ExceptionHandle().fileLoad();
		
		try {
			new ExceptionHandle().myExceptionUse();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
