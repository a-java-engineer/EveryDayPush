package mysqlTest;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conn {

	public static void main(String[] args) {
		// 使用PreparedStatement实现对数据库的插入操作
		
		PreparedStatement ps=null;
		Connection conn=null;
		
	try {
		// 获取连接
		
				// 加载文件
		InputStream is=Conn.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros=new Properties();
		pros.load(is);
		
		//读取文件
		String url=pros.getProperty("url");
		String user=pros.getProperty("user");
		String password=pros.getProperty("password");
		String driverClass=pros.getProperty("driverClass");
				// 注册驱动
		Class.forName(driverClass);
				
				// 获取连接
	 conn=	DriverManager.getConnection(url, user, password);
	// 预编译SQL语句
	String sql="insert into customers(name,email,birth)values(?,?,?)";// ?:占位符
	 ps=conn.prepareStatement(sql);
	// 填充占位符
	ps.setString(1, "哪吒");
	ps.setString(2, "nezha@gmail.com");
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date=sdf.parse("1000-01-01");
	ps.setDate(3, new Date(date.getTime()));
	
	// 执行SQL
	ps.execute();
	
	
//	System.out.println(conn);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//关闭资源
		try {
			if(ps!=null)
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	
	}
	
	
			
}
