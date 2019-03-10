<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Jegyeld</title>
</head>
<body>
	<div>
		<table width="600" border="0">
			<tbody>
				<tr>
					<td><img src="images/logo.jpg" width="250" height="108"
						alt="logo" /></td>
					<td><h1 class="headline">
							<strong>Az online jegyvásárlás</strong>
						</h1></td>
				</tr>
			</tbody>
		</table>
	</div>

	<form action="login" method="post">
		<p>Bejelentkezés:</p>
		<p>
			E-mail cím: <input name="email" type="email" />
		</p>
		<p>
			Jelszó: <input name="password" type="password" />
		</p>
		<p>
			<input type="submit" value="Bejelentkezés" />
		</p>
	</form>
	<c:choose>
		<c:when test="${invalidLogin}">
			<script>
				alert('Érvénytelen felhasználónév vagy jelszó!');
			</script>
		</c:when>
	</c:choose>
</body>
</html>