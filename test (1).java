package test;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		//java的字符串是对象
		String str="hello world!!!";
		String str1=new String("hello world!!!");
		//字节数组,字符数组
		
		test.test_charAt();
		System.out.println("****************");
		test.test_substring();
		System.out.println("****************");
		test.test_toCharArray();
	}
	
	// 返回指定位置的char值--->charAt()
	public static void test_charAt() {
		String str="hello world!!!";
		System.out.println(str.charAt(0)); //输出: h
		//下面会抛出异常:
		//Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 14
//		System.out.println(str.charAt(str.length())); //输出: errer
		System.out.println(str.charAt(str.length()-1)); //输出: !

	}
	
	// 返回字符串的子串--->substring()
	// 注意容易发生字符串截取越界的问题
	public static void test_substring() {
		//字符串的长度为:14
		String str="hello world!!!";
		//去除前6位
		System.out.println(str.substring(6));// 输出:world!!!
		System.out.println(str.substring(0,5));// 输出:hello
		//要截取字符串中的最后几个字符。
		System.out.println(str.substring(str.length()-3));// 输出:!!!
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
	
	// 将字符串转化为字符数组
	public static void test_toCharArray() {
		//字符串的长度为:14
		String str="hello world!!!";
		// 定义一个字符数组,视乎不需要队这个字符数组分配空间
		char[] charArray=str.toCharArray();
		System.out.println(Arrays.toString(charArray));//[h, e, l, l, o,  , w, o, r, l, d, !, !, !]	
	
		/*
		  char数组转成字符串的方法有两种：
    		1.一种是直接将字符数组作为参数构造String对象；
    		2.另一种是使用String的valueOf()方法。
    	  这两种方法得到的字符串都是相同的
		 */
		char[] strs = {'h','e', 'l', 'l', 'o', ' ', '1','2','3'};  //创建一个字符数组
		String string1 = new String(strs);
		String string2 = String.valueOf(strs);
		System.out.println(string1);  //hello 123
		System.out.println(string2);  //hello 123
		System.out.println(string1 == string2);  //false
		/*
		 两者的结果不一样，因为在string1 == string2中，比较的是地址，
		 由于string1 和 string2是两个不同的对象，
		 string1是通过new方法创建的，string2是由valueOf()方法返回的对象，
		 所以二者的地址不一样，等式的结果就是false。
		 */
		System.out.println(string1.equals(string2));  //true
		//String的equals()方法比较的是值

	}
	
	

}
