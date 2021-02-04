package com.exception.controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.exception.common.MyException;

public class RuntimeExceptionTest {
	
	public static void main(String[] args)  throws FileNotFoundException{
		                                   //������ -> JVM���� ������
		                                   //-> �Ϲ� ����ó�� static trace�� ��µǵ��� ����ó������
		//Unchecked Exception
		//ArithmeticException  : ���������� ����� �Ұ����� ��쿡 �߻�
		Scanner sc = new Scanner(System.in);
		System.out.print("�� : ");
		int su = sc.nextInt();
		System.out.print("�� : ");
		int su1 = sc.nextInt();
		try {
			System.out.println(su/su1);
		} catch(ArithmeticException e) {//�� exception�� ���� ������ �� �Ű����� e�� �־���
			System.out.println(e.getMessage());//Exception�� ���� �޼���: / by zero
			e.printStackTrace();//exception �߻������� Ȯ���� �� �ִ� ��±���
			System.out.println("���ڿ� 0�� �ֽ��ϴ�. 0���� ���� ���� �����!");
		}//����ó��
		
		//NegativeArraySizeException : �迭 ���̰� ������ �� �߻�
		//int[] arrInt = new int[-10];//�Ϥ��� ������ ������ �� �� but ���� �� ����
		
		//ArrayIndexOutOfBoundsException : ������ �ε����� �迭 ���̸� �ʰ��� �� �߻�
		String[] names = new String[2];
		try {
			names[3] = "������";//������ ������ �ȳ� but ���� �� ����
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�ε��� ������ �ʰ��߽��ϴ�!");
			String[] temp = new String[names.length+10];
			System.arraycopy(names, 0, temp, 0, names.length);
			names = temp;//names�� �ּҸ� �ٲ�==names�� temp�� ����
			names[3] = "������";
		}//����ó��
		System.out.println("����Ǵ�?");
		System.out.println(names[3]);
		
		//ClassCastingException : Ŭ���� ����ȯ �� ����
		Object obj = new String("�ȳ�");
		//Scanner sc2 = (Scanner)obj;//������ ������ �� �� but ���� �� ����
		
		
		
		//checkedException: �ݵ�� ����ó���� �ؾ� ��
		//FileReader fr = new FileReader("test.txt");
		
		//new ExceptionHandle().testException();//ȣ�� ���, ������ ����
		//new ExceptionHandle().tryCatchTest();
		//new ExceptionHandle().fileLoad();
		
		try {
			new ExceptionHandle().myExceptionUse();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
