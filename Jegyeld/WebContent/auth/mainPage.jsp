<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
	<p>
		Helló <c:out value="${sessionScope.user.firstName}" />!
	</p>
	<form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Kijelentkezés">
	</form>
</body>
</html>