<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println("path =="+path );
System.out.println("basePath =="+basePath );
%>
<body>
<form action="<%=basePath  %>admin/updateArticle" method = "post">
<table>
<tr>
<td>序号<td>
<td>所属栏目<td>
<td>标题</td>
<td>简介</td>
<td>作者</td>
<td>创作时间</td>
</tr>

<tr>
<td><input type = "text" name = "id" value = "${oldArticle.id}"/><td>
<td><select  name="categoryId">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.id}"
                                    <c:if test="${oldArticle.categoryId eq category.id}">selected</c:if>>${category.categoryName}</option>
                        </c:forEach>
                    </select><td>
<td><input type = "text" name ="title" value = "${oldArticle.title}"/></td>
<td><input type = "text" name = "digest" value = "${oldArticle.digest}"/></td>
<td><input type = "text" name = "author" value = "${oldArticle.author}"/></td>
<td><input type = "text" name = "date" value = "${oldArticle.date}"/></td>
</tr>

</table>
    <textarea rows="3" cols="20" name="content" value="${oldArticleContent.content}">${oldArticleContent.content}</textarea>
<input type="submit" value ="修改" />
</form>

</body>
</html>