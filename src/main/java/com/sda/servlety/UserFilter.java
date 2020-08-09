package com.sda.servlety;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = "/user/*")
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest){
            HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
            boolean isLogged = Optional.ofNullable(httpRequest.getSession().getAttribute("isLogged")).isPresent();
            if(isLogged){
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ((HttpServletResponse)servletResponse).sendRedirect("/app/login-page.jsp");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
