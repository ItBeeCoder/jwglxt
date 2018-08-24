<%--
  Created by IntelliJ IDEA.
  User: xiaozhi
  Date: 2017/6/13
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:set var ="ctx" value = "${pageContext.request.contextPath}"/>--%>
<html>
<head>
    <title>Title</title>
</head>
<%
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<body>
<form action ="login" method = "post">
    <label>用户名：</label>
    <input type = "text" name = "username" />
    <label>密码：</label>
    <input type = "password" name = "psw"/>
    <input type = "submit" value = "登录"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type = "reset" value = "重置" />
</form>
<a href = "<%=path %>/index?guest=1">暂不登录</a>
</body>
</html>
