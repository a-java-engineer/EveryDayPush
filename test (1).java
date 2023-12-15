package test;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		//java���ַ����Ƕ���
		String str="hello world!!!";
		String str1=new String("hello world!!!");
		//�ֽ�����,�ַ�����
		
		test.test_charAt();
		System.out.println("****************");
		test.test_substring();
		System.out.println("****************");
		test.test_toCharArray();
	}
	
	// ����ָ��λ�õ�charֵ--->charAt()
	public static void test_charAt() {
		String str="hello world!!!";
		System.out.println(str.charAt(0)); //���: h
		//������׳��쳣:
		//Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 14
//		System.out.println(str.charAt(str.length())); //���: errer
		System.out.println(str.charAt(str.length()-1)); //���: !

	}
	
	// �����ַ������Ӵ�--->substring()
	// ע�����׷����ַ�����ȡԽ�������
	public static void test_substring() {
		//�ַ����ĳ���Ϊ:14
		String str="hello world!!!";
		//ȥ��ǰ6λ
		System.out.println(str.substring(6));// ���:world!!!
		System.out.println(str.substring(0,5));// ���:hello
		//Ҫ��ȡ�ַ����е���󼸸��ַ���
		System.out.println(str.substring(str.length()-3));// ���:!!!
	}

	public static void test_substring() {
		
		String str="hello world";
		String str1="";// ���û�б���,����Ҳ�����ַ���
		// ȥ��ǰnλ,0,1,2,...,str.length
		System.out.println(str.substring(0));// hello world
		System.out.println(str.substring(1));// ello world
		System.out.println(str.substring(2));// llo world
		System.out.println(str.substring(3));// lo world
		System.out.println(str.substring(4));// o world
		System.out.println(str.substring(str.length()-1));// d
		System.out.println(str.substring(str.length()));// ""
		
		System.out.println("____________________________");
		// ��ȡ�ַ��������λ,str.length()-0,str.length()-1,str.length()-2,...,str.length()-str.length()
		// ����,ͬһ������������˼����˾Ͳ�һ������,������˼
		System.out.println(str.substring(str.length()-1));// d
		System.out.println(str.substring(str.length()-2));// ld
		System.out.println(str.substring(str.length()-3));// rld
		System.out.println(str.substring(str.length()-4));// orld
		System.out.println(str.substring(str.length()-str.length()));// hello world
		
		
	}
	
	// ���ַ���ת��Ϊ�ַ�����
	public static void test_toCharArray() {
		//�ַ����ĳ���Ϊ:14
		String str="hello world!!!";
		// ����һ���ַ�����,�Ӻ�����Ҫ������ַ��������ռ�
		char[] charArray=str.toCharArray();
		System.out.println(Arrays.toString(charArray));//[h, e, l, l, o,  , w, o, r, l, d, !, !, !]	
	
		/*
		  char����ת���ַ����ķ��������֣�
    		1.һ����ֱ�ӽ��ַ�������Ϊ��������String����
    		2.��һ����ʹ��String��valueOf()������
    	  �����ַ����õ����ַ���������ͬ��
		 */
		char[] strs = {'h','e', 'l', 'l', 'o', ' ', '1','2','3'};  //����һ���ַ�����
		String string1 = new String(strs);
		String string2 = String.valueOf(strs);
		System.out.println(string1);  //hello 123
		System.out.println(string2);  //hello 123
		System.out.println(string1 == string2);  //false
		/*
		 ���ߵĽ����һ������Ϊ��string1 == string2�У��Ƚϵ��ǵ�ַ��
		 ����string1 �� string2��������ͬ�Ķ���
		 string1��ͨ��new���������ģ�string2����valueOf()�������صĶ���
		 ���Զ��ߵĵ�ַ��һ������ʽ�Ľ������false��
		 */
		System.out.println(string1.equals(string2));  //true
		//String��equals()�����Ƚϵ���ֵ

	}
	
	

}
