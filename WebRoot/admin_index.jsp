<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--导航栏--%>
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
<h3>欢迎${username}</h3>
<%--栏目--%>
<div>
    <ul >
        <c:forEach items="${categoryList}" var="category">
            <li><a href="<%=basePath  %>admin_index.jsp?categoryId=${category.id}">${category.categoryName}</a>
            </li>
        </c:forEach>
    </ul>
</div>
<%--文章--%>
<div>
  <ul>
      <c:forEach items="${articleList}" var="article">
            <li>
            <a href="<%=basePath  %>detail?articleId=${article.id}" target="_blank">${article.title}</a>
            <span>${article.date}</span>
            <span><a href="<%=basePath  %>admin/updateArticle?id=${article.id}">修改</a></span>
            <span><a href="<%=basePath  %>admin/delArticle?id=${article.id}&categoryId=${article.categoryId}">删除</a></span> </li>

      </c:forEach>
    </ul>
<a href="<%=basePath  %>admin/addArticle">添加文章</a>
</div>
<%--退出系统--%>
<a href="<%=basePath  %>logout">退出</a>
</body>
</html>