<form action="main.jsp" method="get">
站点名:<input type="text" name="name">
网址:<input type="text" name="url">
<input type="submit" value="提交" >
</form>

<!-- main.jsp -->

<h1>使用 GET 方法读取数据</h1>

<ul>
    <li>
        <p><b>站点名:</b><%=request.getParameter("name") %></p>
    </li>
    <li>
        <p><b>网址:</b><%=request.getParameter("url") %></p>
    </li>
</ul>
<!-- 
    用户处理好表单,将表单以HTTP报文的形式发送给服务器,这就是来自浏览器的数据,
    main.jsp是来处理表单的jsp,jsp上有获得HTTP报文的数据方式(request.getParameter()),
    main.jsp获得好数据,逻辑处理后,再以HTTP报文的形式发送给浏览器,浏览器以HTML/CSS/JS的
    形式执行,以为自己得到的就是静态页面

 -->
<!-- 
JSP 读取表单数据
    1.getParameter(): 使用 request.getParameter() 方法来获取表单参数的值。

    2.getParameterValues(): 获得如checkbox类（名字相同，但值有多个）的数据。 接收数组变量 ，如checkbox类型

    3.getParameterNames():该方法可以取得所有变量的名称，该方法返回一个 Enumeration。

    4.getInputStream():调用此方法来读取来自客户端的二进制数据流。

 -->

 <!-- 
    你和浏览器打的交道太多了,所以你很熟悉浏览器;但你对于服务器很陌生,所以你在编写代码的时候不会从考虑服务器的角度考虑问题
    为什么是request.getParameter???而且重点是它还是写在jsp里,jsp不是用来响应的吗???怎么会使用request???我之前困惑了好长时间的;
    现在也是拨云见雾了,所谓请求(request)和响应(response)都是从服务器方面来考虑的;request=来自浏览器的数据;response=发送给浏览器的数据

    不要被请求和响应给迷惑住了,这里和计算机网络的请求和相应不一样,
    这里的request和response对象都是代表数据的,不是代表一个过程

  -->