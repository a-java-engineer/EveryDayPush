import java.util.ArrayList;

class Main {
    public static void main(String[] args){

        // 创建一个数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        System.out.println("网站列表: " + sites);


        // 检查 Runoob 是否在这个数组中
        System.out.print("Runoob 是否存在于 arraylist: ");
        System.out.println(sites.contains("Runoob"));

        // 检查 Weibo 是否在这个数组中
        System.out.print("Weibo 是否存在于 arraylist: ");
        System.out.println(sites.contains("Weibo"));
    }
}