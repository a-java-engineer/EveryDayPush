import java.util.ArrayList;

public class Test {

	public static void main(String[] args){
		//定义一个容器
		ArrayList<String>sites=new ArrayList<String>();
		//向容器添加元素,使用add()方法
		sites.add("Google");
		sites.add("Runob");
		sites.add("TaoBao");
		sites.add("WeiBo");
		//可以直接打印它,它实现了toString方法
		 System.out.println(sites);//[Google, Runob, TaoBao, WeiBo]
		//访问 ArrayList 中的元素可以使用 get() 方法：注意：数组的索引值从 0 开始。
		 System.out.println(sites.get(1));//Runob
		// 如果要修改 ArrayList 中的元素可以使用 set() 方法：
		 sites.set(2, "Wiki"); // 第一个参数为索引位置，第二个为要修改的值
		 System.out.println(sites);//[Google, Runob, Wiki, WeiBo]
		 //如果要删除 ArrayList 中的元素可以使用 remove() 方法：
		 sites.remove(3); // 删除第四个元素
	     System.out.println(sites);//[Google, Runob, Wiki]
	     //如果要计算 ArrayList 中的元素数量可以使用 size() 方法：
	     System.out.println(sites.size());//3
	     
	     //使用for循环遍历数组
	     for(int i=0;i<sites.size();i++) {
	    	 System.out.print(sites.get(i)+"|");//Google|Runob|Wiki|
	     }
	     System.out.println();
	     //使用foreach来进行迭代
	     for (String i : sites) {
	            System.out.print(i+"|");//Google|Runob|Wiki|
	        }
		
	}
	

}
