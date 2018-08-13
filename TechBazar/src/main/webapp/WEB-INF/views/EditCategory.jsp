<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url value="/updatecategory" var="url"></c:url>
<form:form action="${url}" modelAttribute="category" method="post">
<table>
<form:input path="categoryId" value="${category.categoryId}"/>
<tr>
<td>Category Name</td>
<td><form:input path="categoryName" value="${category.categoryName}"/></td>
</tr>

<tr>
<td><input type="submit" value="updatecategory"></td>
</tr>
</table>
</form:form>
</body>
</html>