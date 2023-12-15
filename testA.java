import java.lang.reflect.Field;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws Exception {
		// Java的String类,创建和操作字符串
		// 利用String的构造函数来创建字符串
		String st="hello world!!!";
		String str=new String("hello world!!!");
		
//		System.out.println(st==str);
		// String 创建的字符串存储在公共池中,new 创建的字符串存储在堆中
		
		// String类是不可改变的,一旦创建的String对象,那它的值也就无法改变了.
		
		// 字符数组,字节数组
		
//		Test.makeString();
//		
//		
//		Test.printArray();
//		
//		Test.test_substring();
//		
//		Test.test_toCharArray();
		
		
		Test.test_reflection();
		

	}
	
	//字符数组转换为字符串
	public static void makeString() {
		//一个字符数组
		char[] helloArray= {'h','e','l','l','o'};
		
		String helloStr=new String(helloArray);
		
		System.out.println(helloStr);
		
	}
	
	
	public static void printArray() {
		// 一个数组
		int[] intArray=new int[] {1,2,3,4,5};
		
		System.out.println(Arrays.toString(intArray));
		
		
		
		
	}
	
	
	public static void test_substring() {
		
		String str="hello world";
		String str1="";// 这个没有报错,看来也属于字符串
		// 去除前n位,0,1,2,...,str.length
		System.out.println(str.substring(0));// hello world
		System.out.println(str.substring(1));// ello world
		System.out.println(str.substring(2));// llo world
		System.out.println(str.substring(3));// lo world
		System.out.println(str.substring(4));// o world
		System.out.println(str.substring(str.length()-1));// d
		System.out.println(str.substring(str.length()));// ""
		
		System.out.println("____________________________");
		// 截取字符串的最后几位,str.length()-0,str.length()-1,str.length()-2,...,str.length()-str.length()
		// 哈哈,同一个函数换个意思表达了就不一样子了,真有意思
		System.out.println(str.substring(str.length()-1));// d
		System.out.println(str.substring(str.length()-2));// ld
		System.out.println(str.substring(str.length()-3));// rld
		System.out.println(str.substring(str.length()-4));// orld
		System.out.println(str.substring(str.length()-str.length()));// hello world
		
	}
	
	public static void test_toCharArray() {
		//🍷Hello 需要7个char字符进行存储，其中🍷占两个
	    String test="🍷Hello";
	    // 获得小酒杯的码点
	    int index=test.offsetByCodePoints(0, 0);
	    int first=test.charAt(0);
	    int second=test.charAt(1);
	    String resT=""+(char)first+(char)second;
	    System.out.println(resT);
	    int res=test.codePointAt(index);
	    System.out.println(res);
	    
	}
	
	//练习反射
	public static void test_reflection() throws Exception {
		
		//没有公共构造函数,看来是Class对象中的方法会返回Field的对象.
		//参考文档是这样写的:Package-private constructor
//		Class c=new Field().getType();
		
		Field f=new String().getClass().getDeclaredField("hash");
		//参考文档: private int hash; // Default to 0
		System.out.println(f);// 输出:private int java.lang.String.hash
		
		Field f1=new String().getClass().getDeclaredField("COMPACT_STRINGS");
		//参考文档:static final boolean COMPACT_STRINGS;
		System.out.println(f1);// 输出:static final boolean java.lang.String.COMPACT_STRINGS

		Field f2=new String().getClass().getDeclaredField("value");
		//参考文档:private final byte[] value;
		System.out.println(f2);// 输出:private final byte[] java.lang.String.value
	}

}
