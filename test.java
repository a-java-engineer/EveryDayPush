package test;

public class test {

	public static void main(String[] args) {
		//Java String��:�����Ͳ����ַ���
		
		//�ַ����Ĵ���
		String str="hello world!!!";
		
		//���ù��캯�������ַ���
		String str1=new String("hello world~~~");
		
		//String �������ַ����洢�ڹ������У��� new �������ַ��������ڶ��ϣ�
		
		//String ���ǲ��ɸı�ģ�������һ�������� String ����������ֵ���޷��ı���
		// �ͳ���һ��,�����޸�
		
		test.makeString1();

		//�ַ�����ƴ��
		System.out.println("�ҵ�������".concat("����˹����"));
		
		//�����õķ�����ʹ��:'+'��
		System.out.println("�ҵ�������"+"����˹����");
	}
	
	
	public static void makeString1() {
		//�ṩһ���ַ������ʼ���ַ���
		char[] helloArray= {'h','e','l','l','o'};
		
		String helloString=new String(helloArray);
		
		System.out.println(helloString);
		
		
	}

}


// һ���ַ���,�����ַ���,�����ַ���,...
// ����ô����ַ���???
