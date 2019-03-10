package hu.ak_akademia.jegyeld.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.jegyeld.dao.user.GetUserByEmailSqlBuilder;
import hu.ak_akademia.jegyeld.dao.user.GetUserByEmailSqlWriter;
import hu.ak_akademia.jegyeld.dao.user.UserDao;
import hu.ak_akademia.jegyeld.dao.user.UserSqlReader;
import hu.ak_akademia.jegyeld.dto.User;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        List<User> users = userDao.read(new GetUserByEmailSqlBuilder(), new GetUserByEmailSqlWriter(email), new UserSqlReader());
        if (users.isEmpty()) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("invalidLogin", true);
            dispatcher.forward(request, response);
        } else {

        }
    }

}