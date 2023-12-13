package mysqlTest;

import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.Driver;

public class Conn {

	public static void main(String[] args) {
		// JDBC连接数据库方式一
		
		try {
			//1. 获得驱动类的对象
			Driver driver=new com.mysql.cj.jdbc.Driver();
			//2.提供url，指明具体操作的数据	
			String url="jdbc:mysql://localhost:3306/test";
			
			//3.提供Properties的对象，指明用户名和密码
			Properties pros=new Properties();
			pros.setProperty("user", "root");
			pros.setProperty("password", "123456");
			//4.调用driver的connect()，获取连接
			Connection connection=driver.connect(url, pros);
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
			
}
