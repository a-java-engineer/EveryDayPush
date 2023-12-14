package mysqlTest;
import util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Conn {

	public static void main(String[] args) {
		//通用的PreparedStatement实现对数据库的增删改操作
		
//		String sql="delete from customers where id=?";
//		update(sql,3);
		
		// 会报错,SQL里面有关键字,order by
		String sql="update `order` set order_name=? where order_id=?";
		update(sql,"DD",2);
	}	
	public static void update(String sql,Object...args) {
		
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			//1.获取数据库连接
			connection=JDBCUtils.getConnection();
			//2.预编译SQL语句,得到PreparedStatement的实例
			ps=connection.prepareStatement(sql);
			//3.填充占位符
			//肯定要使用循环遍历可变形参了,因为你也不知道有多少个占位符
			for(int i=0;i<args.length;i++) {
				// 注意这里是i+1
				ps.setObject(i+1, args[i]);
			}
			//4.执行SQL语句
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5.关闭资源
			JDBCUtils.closeResource(connection, ps);
		}
		
	}
}
