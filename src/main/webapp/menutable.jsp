<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MenuTable</title>
</head>
<body>
<h1>MenuTable</h1>
	<table border="1">
  		<tr><th>ID</th><th>Name</th><th>category_id</th><th>genre_id</th><th>servings</th></tr>
  		<c:forEach var="mbean" items="${menutable}"> 
  			<tr>
  			<td><c:out value="${mbean.id}" /> </td>
  			<td><c:out value="${mbean.name}" /> </td>
  			<td><c:out value="${mbean.category_id}" /> </td>
  			<td><c:out value="${mbean.genre_id}" /> </td>
  			<td><c:out value="${mbean.servings}" /> </td>
  			</tr>
  		</c:forEach>
  	</table>
	<p><a href="/Sample/Insert0to1Controller">新規メニューの追加</a></p>
</body>
</html>