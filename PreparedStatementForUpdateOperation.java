package mysqlTest;
import util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Conn {

	public static void main(String[] args) {
		//使用PreparedStatement实现对数据库的修改操作
		Connection connection=null;
		PreparedStatement ps=null;
	try {
		// 1.获取数据库的连接
		connection=JDBCUtils.getConnection();
		// 2.预编译SQL语句,返回PreparedStatement的实例
		String sql="update customers set name=? where id=?";
		ps=connection.prepareStatement(sql);
		// 3.填充占位符
		// 这里也是可以使用setObject进行填充占位符的
		ps.setObject(1, "莫扎特");
		ps.setObject(2, 18);
		//4.执行SQL
		ps.execute();	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//5.资源的关闭
		JDBCUtils.closeResource(connection, ps);
	}
		
	}		
}
