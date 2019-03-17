package hu.ak_akademia.jegyeld.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String loginPage = request.getContextPath() + "/index.jsp";
        HttpSession session = request.getSession(false);

        boolean isLoginPage = request.getRequestURI()
                .equals(loginPage);
        if (!isLoginPage && (session == null || session.getAttribute("user") == null)) {
            response.sendRedirect(loginPage);
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }
    }

}