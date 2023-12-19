<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>使用jsp:useBean动作标签</title>
</head>
<body>
	<h1>构建了3个对象</h1>
	<jsp:useBean id="p1" class="com.runoob.main.Person" />
	<jsp:useBean id="p2" class="com.runoob.main.Person" />
	<jsp:useBean id="p3" class="com.runoob.main.Person" />
	
	<jsp:setProperty property="name" name="p1" value="张三"/>
	<jsp:setProperty property="age" name="p1" value="10"/>
	<jsp:setProperty property="name" name="p2" value="李四"/>
	<jsp:setProperty property="age" name="p2" value="11"/>
	<jsp:setProperty property="name" name="p3" value="王五"/>
	<jsp:setProperty property="age" name="p3" value="12"/>
	
	<!--获取Bean  -->
	<!-- 无序列表 -->
	<ul>
		<li><%="{"%><jsp:getProperty property="name" name="p1"/><%="," %><jsp:getProperty property="age" name="p1"/><%="}" %></li>
		<li><%="{"%><jsp:getProperty property="name" name="p2"/><%="," %><jsp:getProperty property="age" name="p2"/><%="}" %></li>
		<li><%="{"%><jsp:getProperty property="name" name="p3"/><%="," %><jsp:getProperty property="age" name="p3"/><%="}" %></li>
	</ul>
	

<!-- 
package com.runoob.main;

public class Person {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//属性
	private String name;
	private int age;
	

}




 -->	



</body>
</html>


