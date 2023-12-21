package mysqlTest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class Conn {

	public static void main(String[] args) throws SQLException {
		//JDBC连接方式1
		
		//1.实例化Driver对象
		Driver driver=new com.mysql.cj.jdbc.Driver();
		
		//2.提供url,指明要操作的数据
		String url="jdbc:mysql://localhost:3306/test";
		
		//3.提供Properties对象,提供连接的用户名和密码
		Properties pros=new Properties();
		pros.setProperty("user", "root");
		pros.setProperty("password", "123456");
		
		//4.使用Driver对象的connect方法来获取数据库的连接
		Connection connection=driver.connect(url, pros);
		System.out.println(connection);
		
		
	}
}

//做任何事情都是有步骤的,比如:第一步... 第二步... 第三步... 第四步... 直到你的问题解决