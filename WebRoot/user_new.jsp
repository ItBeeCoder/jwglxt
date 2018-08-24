<%--
  Created by IntelliJ IDEA.
  User: xiaozhi
  Date: 2017/6/20
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
</head>
<body>
<form action = "<%=basePath %>admin/addUser" method="post">
    <div>
        <label>用户名：</label>
        <input type="text" name = "username"/>
    </div>
    <div>
        <label>密 码：</label>
        <input type="text" name = "psw"/>
    </div>
    <input type="submit" value="提交"/>
    <input type = "reset" value="重置"/>
</form>
</body>
</html>
