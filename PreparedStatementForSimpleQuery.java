package mysqlTest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import util.JDBCUtils;

public class Conn {

	public static void main(String[] args){
		
		//使用PreparedStatement对表中的数据进行简单查询
		try {
			//1.获取连接
			Connection conn=JDBCUtils.getConnection();
			//2.预编译SQL语句
			String sql="select name,email,birth from customers where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			//3.填充占位符
			ps.setInt(1, 21);
			//4.执行SQL，返回结果集
			ResultSet rs=ps.executeQuery();
			//6.获取结果集的源数据
			ResultSetMetaData rsmt=rs.getMetaData();
			//7.处理结果集
			if(rs.next()) {
				for(int i=0;i<rsmt.getColumnCount();i++) {
					//获取列值
					Object obj=rs.getObject(i+1);
					System.out.println(obj);
				}
			}
			//8.关闭资源
			JDBCUtils.closeResource(conn, ps);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

//做任何事情都是有步骤的,比如:第一步... 第二步... 第三步... 第四步... 直到你的问题解决
//show processlist;