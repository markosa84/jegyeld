<%@page import="hu.ak_akademia.jegyeld.dao.user.DeleteUserSqlWriter"%>
<%@page import="hu.ak_akademia.jegyeld.dao.user.DeleteUserSqlBuilder"%>
<%@page import="hu.ak_akademia.jegyeld.dao.user.CreateUserSqlWriter"%>
<%@page import="hu.ak_akademia.jegyeld.dao.user.CreateUserSqlBuilder"%>
<%@page import="java.time.LocalDate"%>
<%@page import="hu.ak_akademia.jegyeld.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="hu.ak_akademia.jegyeld.dao.user.UserSqlReader"%>
<%@page import="hu.ak_akademia.jegyeld.dao.user.GetUserByEmailSqlWriter"%>
<%@page
	import="hu.ak_akademia.jegyeld.dao.user.GetUserByEmailSqlBuilder"%>
<%@page import="hu.ak_akademia.jegyeld.dao.user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>

	<%
	    UserDao userDao = new UserDao();
		    List<User> users = userDao.read(new GetUserByEmailSqlBuilder(), new GetUserByEmailSqlWriter("teszt.elek@gmail.com"), new UserSqlReader());
		    out.print(users.get(0));

		    User user = new User.Builder().firstName("Jakab")
		            .lastName("Gipsz")
		            .address("Fürdő utca 3")
		            .email("gipsz.jakab@gmail.com")
		            .dateOfBirth(LocalDate.of(1980, 2, 20))
		            .password("654321")
		            .phone("+36 80 987 6543")
		            .build();
		    userDao.create(new CreateUserSqlBuilder(), new CreateUserSqlWriter(user));

		    userDao.delete(new DeleteUserSqlBuilder(), new DeleteUserSqlWriter(4));
	%>

</body>
</html>