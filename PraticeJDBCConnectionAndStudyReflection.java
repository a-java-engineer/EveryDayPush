package mysqlTest;
import util.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;
public class Conn {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		
		//虽然周六周日是复习旧的重难点,但围绕重难点的新知识点也可以在周六周日学习
		//因为我了解到学习关于新的重难点的知识点也是强化旧的重难点的知识点
		
		//JDBC中的数据库连接五中出现了反射,那我们先看看反射的学习
		// 获得Class对象有三种方式
		//1. 使用Object类(所有类的超类)的getClass()方法返回一个Class类型的实例
		//2.调用静态方法forName()获得类名对应的Class对象
		//3.如果T是任意的Java类型(或void关键字),T.class将代表匹配的类对象
		
		//准备一个自定义Student类测试一下...
		//方式一:
		Student stu=new Student();
		Class classStu=stu.getClass();
		System.out.println(classStu.getName());//mysqlTest.Student
		//方式二:
		Class classStu1=Class.forName("mysqlTest.Student");
		//判断方式一和方式二获取的Class对象是否相同
		System.out.println(classStu==classStu1);//true
		//方式三:
		Class classStu2=Student.class;
		//判断方式二和方式三获取的Class对象是否相同
		System.out.println(classStu1==classStu2);//true
		
		//所以,验证一句话:注意：在运行期间，一个类，只有一个Class对象产生。!!!
		//三种方式常用第二种，第一种对象都有了还要反射干什么。第三种需要导入类的包，依赖太强，不导包就抛编译错误。
		//一般都第二种，一个字符串可以传入也可写在配置文件中等多种方法(这个配置文件,在JDBC中我已经体会到了😘😘😘)
		
		
		//通过反射获取类构造函数并使用
		/*
		 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
		 * 
		 * 1.获取构造方法：
		 * 		1).批量的方法：
		 * 			public Constructor[] getConstructors()：所有"公有的"构造方法
		            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
		     
		 * 		2).获取单个的方法，并调用：
		 * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
		 * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
		 * 		
		 * 			调用构造方法：
		 * 			Constructor-->newInstance(Object... initargs)
		 */
		
		//使用第二种获得Class对象的方式来进行测试
		Class stuClassObjectTestConstructor=Class.forName("mysqlTest.Student");
		//2.获取所有公有构造方法
		System.out.println("**********************所有公有构造方法*********************************");
		Constructor[] conArray = stuClassObjectTestConstructor.getConstructors();
		for(Constructor c : conArray){
			System.out.println(c);
		}
		/*
		 **********************所有公有构造方法*********************************
			public mysqlTest.Student(java.lang.String,int,char)
			public mysqlTest.Student(java.lang.String)
			public mysqlTest.Student()

		 */
		//3.获取所有的构造方法(包括：私有、受保护、默认、公有)
		System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
		conArray = stuClassObjectTestConstructor.getDeclaredConstructors();
		for(Constructor c : conArray){
			System.out.println(c);
		}
		/*
		 ************所有的构造方法(包括：私有、受保护、默认、公有)***************
			protected mysqlTest.Student(char)
			private mysqlTest.Student(int)
			public mysqlTest.Student(java.lang.String,int,char)
			public mysqlTest.Student(java.lang.String)
			public mysqlTest.Student()
		 */
		//4.获取公有、无参的构造方法
		System.out.println("*****************获取公有、无参的构造方法*******************************");
		Constructor con = stuClassObjectTestConstructor.getConstructor(null);// 搞懂了,可以填:int.class,String.class ...
		//1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
		//2>、返回的是描述这个无参构造函数的类对象。	
		System.out.println(con);//public mysqlTest.Student()
		//构造Student对象,因为我构造对象了,所以公有无参的构造函数执行了...
		Object obj=con.newInstance();//调用了公有、无参构造方法执行了。。。
		Student st=(Student)obj;
		System.out.println(st);//Student [name=张三, age=10, sex=M]
		//5.获取私有构造方法，并调用
		System.out.println("******************获取私有构造方法，并调用*******************************");
		con = stuClassObjectTestConstructor.getDeclaredConstructor(int.class);
		System.out.println(con);//private mysqlTest.Student(int)
		//调用构造方法
		con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
		obj = con.newInstance(30);//私有的构造方法   age：30
		st=(Student)obj;
		System.out.println(st);//Student [name=, age=30, sex= ]
		
		
		//获取成员变量并调用
		/*
		 * 获取成员变量并调用：
		 * 
		 * 1.批量的
		 * 		1).Field[] getFields():获取所有的"公有字段"
		 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
		 * 2.获取单个的：
		 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
		 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
		 * 
		 * 	 设置字段的值：
		 * 		Field --> public void set(Object obj,Object value):
		 * 					参数说明：
		 * 					1.obj:要设置的字段所在的对象；
		 * 					2.value:要为字段设置的值；
		 * 
		 */
		//1.获取Class对象
		Class stuClassObjectTestField=Class.forName("mysqlTest.Student");
		//2.获取字段
		System.out.println("************获取所有公有的字段********************");
		Field[] fieldArray = stuClassObjectTestField.getFields();
		//哈哈,一开始我还以为我写错了呢,但思考一会,我的Student类好像没有公共字段呀~~~
		for(Field f : fieldArray){
			System.out.println(f);
		}
		/*
		 ************获取所有公有的字段********************
		 */
		System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
		fieldArray = stuClassObjectTestField.getDeclaredFields();
		for(Field f : fieldArray){
			System.out.println(f);
		}
		/*
		 ************获取所有的字段(包括私有、受保护、默认的)********************
			private java.lang.String mysqlTest.Student.name
			private int mysqlTest.Student.age
			private char mysqlTest.Student.sex
		 */
		
		// 获得公有字段并调用写不了呀,我要在想我的Student类添加几个公有字段的话,我上面调用构造函数的答案就要全部重新跑了...呜呜呜~~,下回吧~~~
		System.out.println("**************获取私有字段****并调用********************************");
		Field f = stuClassObjectTestField.getDeclaredField("name");
		System.out.println(f);
		f.setAccessible(true);//暴力反射，解除私有限定
		//获取一个对象
		Object objTest=stuClassObjectTestField.getConstructor().newInstance();//调用了公有、无参构造方法执行了。。。
		f.set(objTest, "开心超人");
		Student s=(Student)objTest;
		System.out.println(s);//Student [name=开心超人, age=10, sex=M] 因为我的无参构造函数里面设置了默认值,所以输出会这样


		//获取成员方法并调用
		/*
		 * 获取成员方法并调用：
		 * 
		 * 1.批量的：
		 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
		 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
		 * 2.获取单个的：
		 * 		public Method getMethod(String name,Class<?>... parameterTypes):
		 * 					参数：
		 * 						name : 方法名；
		 * 						Class ... : 形参的Class类型对象
		 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
		 * 
		 * 	 调用方法：
		 * 		Method --> public Object invoke(Object obj,Object... args):
		 * 					参数说明：
		 * 					obj : 要调用方法的对象；
		 * 					args:调用方式时所传递的实参；
		):
		 */
		//1.获取Class对象
				Class stuClassObjectTesMethod = Class.forName("mysqlTest.Student");
				//2.获取所有公有方法
				System.out.println("***************获取所有的”公有“方法*******************");
//				stuClassObjectTesMethod.getMethods();
				Method[] methodArray = stuClassObjectTesMethod.getMethods();
				for(Method m : methodArray){
					System.out.println(m);
				}
				/*
				 ***************获取所有的”公有“方法*******************
					public java.lang.String mysqlTest.Student.toString()
					public void mysqlTest.Student.show1(java.lang.String)
					public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
					public final void java.lang.Object.wait() throws java.lang.InterruptedException
					public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
					public boolean java.lang.Object.equals(java.lang.Object)
					public native int java.lang.Object.hashCode()
					public final native java.lang.Class java.lang.Object.getClass()
					public final native void java.lang.Object.notify()
					public final native void java.lang.Object.notifyAll()
				 */
				System.out.println("***************获取所有的方法，包括私有的*******************");
				methodArray = stuClassObjectTesMethod.getDeclaredMethods();
				for(Method m : methodArray){
					System.out.println(m);
				}
				/*
				 ***************获取所有的方法，包括私有的*******************
					public java.lang.String mysqlTest.Student.toString()
					public void mysqlTest.Student.show1(java.lang.String)
					private java.lang.String mysqlTest.Student.show4(int)
					protected void mysqlTest.Student.show2()
					void mysqlTest.Student.show3()
				 */
				System.out.println("***************获取公有的show1()方法*******************");
				Method m = stuClassObjectTesMethod.getMethod("show1", String.class);
				System.out.println(m);//public void mysqlTest.Student.show1(java.lang.String)
				//实例化一个Student对象
				Object objMethod = stuClassObjectTesMethod.getConstructor().newInstance();//调用了公有、无参构造方法执行了。。。
				m.invoke(objMethod, "刘德华");//调用了：公有的，String参数的show1(): s = 刘德华
				
				System.out.println("***************获取私有的show4()方法******************");
				m = stuClassObjectTesMethod.getDeclaredMethod("show4", int.class);
				System.out.println(m);//private java.lang.String mysqlTest.Student.show4(int)
				m.setAccessible(true);//解除私有限定
				//调用了，私有的，并且有返回值的，int参数的show4(): age = 20
				Object result = m.invoke(objMethod, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
				System.out.println("返回值：" + result);//返回值：abcd
		



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
	
	
	public static void getConnection1() {
		//这里面没有关闭资源!!!
		
		// JDBC连接数据库方式一
		
				try {
					//1.实例化Driver接口的对象
					//面向接口编程,父类的指针指向子类的对象
					Driver driver=new com.mysql.cj.jdbc.Driver();
					//2.提供url,指明要操作的数据
					String url="jdbc:mysql://localhost:3306/test";
					//3.提供Properties类的对象,指明用户名和密码
					Properties pros=new Properties();
					pros.setProperty("user", "root");
					pros.setProperty("password", "123456");
					//4.获取连接
					Connection connection=driver.connect(url, pros);
					System.out.println(connection);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	public static void getConnection3() {
		// JDBC连接数据库方式三
				try {
					// 1.提供四个基本连接数据
					String url="jdbc:mysql://localhost:3306/test";
					String user="root";
					String password="123456";
					String className="com.mysql.cj.jdbc.Driver";
					//2.利用反射创建驱动
					Driver driver=(Driver)Class.forName(className).newInstance();
					//3.注册驱动
					//虽然数据库连接成功了,但是还是可以拓展自己的知识,你对这个DriverManager类熟悉吗?它还有什么方法?它的文档介绍你看了吗?它还有什么作用？
					//之前数据库方式连接一中,使用的是接口Driver中定义的connect()方法,为什么还需要定义一个DriverManager类来换一种方式连接呢?
					DriverManager.registerDriver(driver);
					//4.获取连接
					Connection connection=DriverManager.getConnection(url, user, password);
					System.out.println(connection);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public static void getConnection5() {
		//JDBC连接数据库方式五
				try {
					//1.加载配置文件
					//这个反射的练习还需要加强,老是写不出来!!!
					InputStream is=Conn.class.getClassLoader().getResourceAsStream("jdbc.properties");
					Properties pros=new Properties();
					pros.load(is);
					//2.读取配置文件
					String url=pros.getProperty("url");
					String user=pros.getProperty("user");
					String password=pros.getProperty("password");
					String driverName=pros.getProperty("driverName");
					//3.注册驱动
					Class.forName(driverName);
					//4.获取连接
					Connection connection=DriverManager.getConnection(url, user, password);
					System.out.println(connection);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
// 测试反射
class Student{
	// 3个字段
	private String name="";
	private int age=0;
	private char sex=' ';
	
	
	
	// 多个构造函数
	
	//1.无参构造函数
	public Student() {
		System.out.println("调用了公有、无参构造方法执行了。。。");
		this.name="张三";
		this.age=10;
		this.sex='M';
	};
	//2.包含一个name的构造函数
	public Student(String name) {
		System.out.println("调用了包含一个name的构造函数执行了。。。:"+name);
	}
	//3.有多个参数的构造方法
	public Student(String name ,int age,char sex){
		System.out.println("有多个参数的构造方法执行了"+"姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。
	}
	//4.私有构造方法
	private Student(int age){
		this.age=age;
		System.out.println("私有的构造方法   age："+ age);
	}
	//5.受保护的构造方法
	protected Student(char sex){
		System.out.println("受保护的构造方法 sex = " + sex);
	}
	//**************成员方法***************//
	public void show1(String s){
		System.out.println("调用了：公有的，String参数的show1(): s = " + s);
	}
	protected void show2(){
		System.out.println("调用了：受保护的，无参的show2()");
	}
	void show3(){
		System.out.println("调用了：默认的，无参的show3()");
	}
	private String show4(int age){
		System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
		return "abcd";
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}

// 把握住你现有的东西,不要为没有的东西患得患失.你所拥有的东西,也是别人所羡慕的东西
//那我所拥有了什么:现在有一个私人住所,没有在寝室住;对自己的未来有一个清晰的认知;学习上进;知道学习要专注重难点的知识;
//那我所没有的东西:很多钱,很多好色女人,...很多