import java.util.ArrayList;
import java.util.Comparator;

class Main {
    public static void main(String[] args){
//sort() 方法根据指定的顺序对动态数组中的元素进行排序。        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();
        
        sites.add("Runoob");
        sites.add("Google");
        sites.add("Wiki");
        sites.add("Taobao");
        System.out.println("网站列表: " + sites);

        System.out.println("不排序: " + sites);

        // 元素进行升序排列
//Java Comparator 接口的 naturalOrder() 方法指定元素以自然顺序（升序）排序。        sites.sort(Comparator.naturalOrder());
        System.out.println("排序后: " + sites);
    }
}
//Comparator 接口的 reverseOrder() 方法指定以相反的顺序（降序）对元素进行排序。