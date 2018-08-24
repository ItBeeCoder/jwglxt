<%--
  Created by IntelliJ IDEA.
  User: xiaozhi
  Date: 2017/6/20
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
</head>
<body>
<div id="navigationBar">
    <a href="<%=basePath  %>admin/index">文章管理</a>
    <a href="<%=basePath  %>admin/category">栏目管理</a>
    <%
    HttpSession session1 = request.getSession();
    String username = (String) session1.getAttribute("username");
        if ("admin".equals(username)) {
    %>
    <a href="<%=basePath  %>admin/user">用户管理</a>
    <%
        }
    %>
</div>
<div>
    <table>
        <tr>
            <td>栏目名称</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${categoryList}" var="category">
            <tr>
                <td>
                    <label>${category.categoryName}</label>
                </td>
                <td><a href="<%=basePath  %>admin/category/alter?id=${category.id}">修改</a></td>
                <td><a href="<%=basePath  %>admin/category/del?id=${category.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    </ul>
    <a href="<%=basePath  %>admin/category/add">添加栏目</a>
</div>
</body>
</html>
