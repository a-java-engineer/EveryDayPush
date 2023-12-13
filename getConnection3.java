package mysqlTest;

import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Conn {

	public static void main(String[] args) {
		// JDBC连接数据库方式三
		
		//电脑没有设置MySQL的自启动,我已经感觉到麻烦了,每次开始都要我手动去开
		// 搜索 计算机管理 -> 选择服务 -> 找到MySQL选择开启服务. 
		
		Class c;
		Connection connection=null;
		try {
			//1.数据库连接的4个基本要素
			String url="jdbc:mysql://localhost:3306/test";
			String user="root";
			String password="123456";
			String driverName="com.mysql.cj.jdbc.Driver";
			//2.实例化Driver
			c = Class.forName(driverName);
			Driver driver=(Driver)c.newInstance();
			//3.注册驱动
			DriverManager.registerDriver(driver);
			//4.获取连接
		 connection=DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
			
}
