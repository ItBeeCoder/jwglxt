<%@ page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION" %>
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
<h2>${article.title}</h2>
<div><label>作者：${article.author}</label>&nbsp;&nbsp;<label>摘要：${article.digest}</label>&nbsp;&nbsp;<label>时间：${article.date}</label></div>
<div><label>内容：</label>${artCon.content}</div>
<%
HttpSession session1 = request.getSession();
String isGuest  =(String) session1.getAttribute("isGuest");
if(isGuest!=null){
%>
<a href="<%=basePath  %>index?categoryId=${article.categoryId}">返回</a>
<%
    }else{
    %>
<a href="<%=basePath  %>admin/index?categoryId=${article.categoryId}">返回</a>
<%
    }
%>
</body>
</html>