
<%--
  Created by IntelliJ IDEA.
  User: xiaozhi
  Date: 2017/6/20
  Time: 16:51
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
<div id = "navigationBar">
    <a href="<%=basePath  %>admin/index">文章管理</a>
    <a href="<%=basePath  %>admin/category">栏目管理</a>
    <%
        HttpSession session1 = request.getSession();
        String username = (String)session1.getAttribute("username");
        if("admin".equals(username)){
    %>
    <a href="<%=basePath  %>admin/user">用户管理</a>
    <%
        }
    %>
</div>
<div id = "content">
    <div>
<table>
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${userList}" var="user">
    <tr>
            <td>${user.username}</td>
            <td>${user.psw}</td>
            <td><a href="<%=basePath  %>admin/user/alter?id=${user.id}">修改</a> </td>
            <td><a href="<%=basePath  %>admin/user/del?id=${user.id}">删除</a> </td>
    </tr>
    </c:forEach>
</table>
    </div>
    <div><a href="<%=basePath  %>admin/addUser">添加用户</a></div>
</div>
</body>
</html>
