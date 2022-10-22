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
	<p>情報を入力してください</p>
	<form action="/Sample/Insert1to2Controller" method="POST" >
		<table border="1">
		  <tr><th>メニュー名</th><td><input type="text" name="name" required /></td></tr>
		  <tr><th>何人前</th><td><input type="number" name="servings" required /></td></tr>
		</table>
		<c:forEach var="cbean" items="${categorytable}">
			<input type="radio" name="category_id" value="${cbean.id}"/>
			<c:out value="${cbean.category}" />
		</c:forEach><br />
		<c:forEach var="gbean" items="${genretable}">
			<input type="radio" name="genre_id" value="${gbean.id}" />
			<c:out value="${gbean.genre}" />
		</c:forEach>
		
	<p><input type="submit" value="レコード追加" /></p>
	</form>
	

</body>
</html>