<%--
  Created by IntelliJ IDEA.
  User: xiaozhi
  Date: 2017/6/20
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<head>
    <title>Title</title>
</head>
<body>
<form action = "<%= basePath %>admin/user/alter" method="post">
<div>
    <div>
        <label>用户名：</label>
        <input type="text" name="username" value = "${user.username}"/>
    </div>
    <div>
        <label>密 码：</label>
        <input type="text" name = "psw" value="${user.psw}"/>
    </div>
    <div>
        <input type="hidden" name = "id" value="${user.id}"/>
    </div>
</div>
    <div><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/> </div>
</form>
</body>
</html>
