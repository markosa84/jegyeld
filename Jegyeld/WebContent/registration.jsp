<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Új felhasználó regisztrálása</title>
<link rel="stylesheet" type="text/css" href="jegyeld.css">
</head>
<body>
	<form action="registerNewUser" method="post">
		<div>
			<fieldset class="fieldset-auto-width">
				<legend>Regisztráció</legend>
				<p>
					<label class="field" for="lastName">* Vezetéknév</label><input type="text" id="lastName" name="lastName" value="${lastName}" />
				</p>
				<p>
					<label class="field" for="firstName">* Keresztnév</label><input type="text" id="firstName" name="firstName" value="${firstName}" />
				</p>
				<p>
					<label class="field" for="dateOfBirth">Születési dátum</label><input type="date" id="dateOfBirth" name="dateOfBirth" value="${dateOfBirth}" />
				</p>
				<p>
					<label class="field" for="address">* Cím</label><input type="text" id="address" name="address" value="${address}" />
				</p>
				<p>
					<label class="field" for="email">* E-mail</label><input type="email" id="email" name="email" value="${email}" />
				</p>
				<p>
					<label class="field" for="phone">Telefonszám</label><input type="tel" id="phone" name="phone" value="${phone}" />
				</p>
				<p>
					<label class="field" for="password">* Jelszó</label><input type="password" id="password" name="password" />
				</p>
				<p>
					<label class="field" for="passwordConfirmation">* Jelszó megerősítés</label><input type="password" id="passwordConfirmation" name="passwordConfirmation" />
				</p>
				<p>
					<input type="checkbox" name="acceptPrivacyPolicy" />* Elfogadom az <a href="privacyPolicy.html">adatkezelési irányelvek</a>et
				</p>
				<div class="right-aligned">
					<input type="reset" value="Törlés" /> <input type="submit" value="Regisztrálok" />
				</div>
			</fieldset>
		</div>
	</form>
	<c:choose>
		<c:when test="${invalidRegistrationMessage != null}">
			<script>
				alert('${invalidRegistrationMessage}');
			</script>
		</c:when>
	</c:choose>
</body>
</html>