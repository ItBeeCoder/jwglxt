<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<body>
<div>
    <form action="<%=basePath  %>admin/category/add" method="post">
        <label>栏目id</label>
        <input type="text" name="id" />
        <label>栏目名称</label>
        <input type="text" name="categoryName" />
        <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
    </form>
</div>
</body>
</html>