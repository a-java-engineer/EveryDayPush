package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import mysqlTest.Conn;

// 数据库操作的方法
public class JDBCUtils {
	public static Connection getConnection() throws Exception {
		
		
		Connection connection=null;
		PreparedStatement ps=null;
		//获取连接
	
		//加载配置文件
		InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros =new Properties();
		pros.load(is);
		//读取配置文件
		String url=pros.getProperty("url");
		String user=pros.getProperty("user");
		String password=pros.getProperty("password");
		String driverName=pros.getProperty("driverName");
			//注册驱动
		Class.forName(driverName);
			//获取连接
		connection=DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	public static void closeResource(Connection connection,Statement ps) {
		//关闭资源
		try {
			if(ps!=null)
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
