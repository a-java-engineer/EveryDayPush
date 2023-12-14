package mysqlTest;
import java.text.SimpleDateFormat;
import util.JDBCUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
public class Conn {

	public static void main(String[] args) {
		//使用PreparedStatement实现对数据库的添加操作
		Connection connection=null;
		PreparedStatement ps=null;
		//获取连接
		try {
			connection=JDBCUtils.getConnection();
			// 预编译SQL语句
			String sql="insert into customers(name,email,birth)values(?,?,?)";//?占位符
			 ps=connection.prepareStatement(sql);
			//填充占位符
			ps.setString(1, "猪悟能");
			ps.setString(2, "zhuwuneng@139.com");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date=sdf.parse("1122-01-01");
			ps.setDate(3, new Date(date.getTime()));
			//执行SQL
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 关闭资源
			JDBCUtils.closeResource(connection, ps);
		}
	
		
		
	}
	
	
			
}
