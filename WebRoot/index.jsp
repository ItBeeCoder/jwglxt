<%--
  Created by IntelliJ IDEA.
  User: xiaozhi
  Date: 2017/6/19
  Time: 12:34
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
<ul >
    <c:forEach items="${categoryList}" var="category">
        <li><a href="<%=basePath %>index?categoryId=${category.id}">${category.categoryName}</a>
        </li>
    </c:forEach>
</ul>

<ul >
<c:forEach items="${articleList}" var="article">
    <li >
        <a href="<%=basePath %>detail?articleId=${article.id}" target="_blank">${article.title}</a>
        <span>${article.date}</span>
    </li>
</c:forEach>
</ul>
<a href="<%=basePath %>logout">退出</a>
</body>
</html>
