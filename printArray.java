package test;

import java.util.Arrays;

public class printArray {
	private static String langs[]=new String[]{"c++","java","python","go"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ѧ������������Ҫ
		printArray.method1();//c++ java python go
		System.out.println();
		printArray.method2();//c++ java python go
		System.out.println();
		printArray.method3();//[c++, java, python, go]
	}
	public static void method1() {
		//��ͨforѭ��
		for(int i=0;i<langs.length;i++) {
			System.out.print(langs[i]+" ");
		}	
	}
	
	public static void method2() {
		//���ڷ�Χforѭ��
		for(String lang:langs)	
			System.out.print(lang+" ");
	}
	public static void method3() {
		//����Arrays���е�toString()����
			System.out.print(Arrays.toString(langs));
	}
}
