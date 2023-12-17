import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args){
		// 使用非常有用的工具类Collections,位于java.util包下
		//定义一个ArrayList对象
		ArrayList<String>sites=new ArrayList<String>();
		sites.add("Taobao");
        sites.add("Wiki");
        sites.add("Runoob");
        sites.add("Weibo");
        sites.add("Google");
        //添加的顺序就是输出的顺序
        System.out.println(sites);//[Taobao, Wiki, Runoob, Weibo, Google]
        //// 字母排序
        Collections.sort(sites);//[Google, Runoob, Taobao, Weibo, Wiki]
        System.out.println(sites);
	}
	

}
