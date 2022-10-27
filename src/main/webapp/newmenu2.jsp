<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規メニューの追加</title>
</head>
<body>
	<h1>新規メニューの追加</h1>
	<p>メニュー：</p><c:out value="${ newmenu.name }" />
	<form action="/Sample/Insert2to3Controller" method="POST" >
		<p>食材</p>
		<c:forEach var="ibean" items="${ingredienttable}">
			<input type="checkbox" name="ingredient_id" value="${ibean.id}"/>
			<c:out value="${ibean.name}" />
		</c:forEach>
		<p>調味料</p>
		<c:forEach var="sbean" items="${spicetable}">
			<input type="checkbox" name="spice_id" value="${sbean.id}" />
			<c:out value="${sbean.name}" />
		</c:forEach>
		
	<p><input type="submit" value="レコード追加" /></p>
	</form>

</body>
</html>