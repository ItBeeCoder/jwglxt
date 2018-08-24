<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新栏目</title>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
</head>
<body>
<div>
    <form action="<%=basePath  %>admin/category/alter" method="post">
        <label>原栏目id</label>
        <input type="text" name="id" value="${category.id}"/>
        <label>原栏目名称</label>
        <input type="text" name="categoryName" value="${category.categoryName}"/>
        <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
    </form>
</div>
</body>
</html>