package test;

public class test {

	public static void main(String[] args) {
		//Java String类:创建和操作字符串
		
		//字符串的创建
		String str="hello world!!!";
		
		//利用构造函数创建字符串
		String str1=new String("hello world~~~");
		
		//String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上：
		
		//String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了
		// 和常量一样,不可修改
		
		test.makeString1();

		//字符串的拼接
		System.out.println("我的名字是".concat("刘易斯·清"));
		
		//更常用的方法是使用:'+'号
		System.out.println("我的名字是"+"刘易斯·清");
	}
	
	
	public static void makeString1() {
		//提供一个字符数组初始化字符串
		char[] helloArray= {'h','e','l','l','o'};
		
		String helloString=new String(helloArray);
		
		System.out.println(helloString);
		
		
	}

}


// 一个字符串,二个字符串,三个字符串,...
// 你怎么理解字符串???
