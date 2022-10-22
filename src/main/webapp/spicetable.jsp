<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spice Table</title>
</head>
<body>
<h1>Spice Table</h1>
	<table border="1">
  		<tr><th>ID</th><th>Name</th><th>Kana</th></tr>
  		<c:forEach var="sbean" items="${spicetable}"> 
  			<tr>
  			<td><c:out value="${sbean.id}" /> </td>
  			<td><c:out value="${sbean.name}" /> </td>
  			<td><c:out value="${sbean.kana}" /> </td>
  			</tr>
  		</c:forEach>
  	</table>
</body>
</html>

